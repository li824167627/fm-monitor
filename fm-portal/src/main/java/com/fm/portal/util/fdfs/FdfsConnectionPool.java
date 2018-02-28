package com.fm.portal.util.fdfs;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class FdfsConnectionPool {

	private static String FDFS_CONFIG = "fastdfs/fdfs_client.conf";

	private static int size = 5;// 最大连接数
	private ConcurrentHashMap<StorageClient, Object> busyConnectPool; // 被使用的连接
	private ArrayBlockingQueue<StorageClient> idleConnectionPool; // 空闲的连接

	private Object obj = new Object();
	private static FdfsConnectionPool instance;

	public FdfsConnectionPool() {
		busyConnectPool = new ConcurrentHashMap<>();
		idleConnectionPool = new ArrayBlockingQueue<>(size);
		initPool(size);
	}

	// 初始化连接池
	private void initPool(int size) {
		initClientGlobal();
		TrackerClient trackerClient = new TrackerClient();
		TrackerServer trackerServer = null;
		StorageClient storageClient = null;
		StorageServer storageServer = null;
		try {
			trackerServer = trackerClient.getConnection();
			// storageServer = trackerClient.getStoreStorage(trackerServer);
			for (int i = 0; i < size; i++) {
				storageClient = new StorageClient(trackerServer, storageServer);
				idleConnectionPool.add(storageClient);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (trackerServer != null) {
				try {
					trackerServer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 初始化客户端
	private void initClientGlobal() {
		try {
			ClientGlobal.init(FDFS_CONFIG);
		} catch (IOException | MyException e) {
			e.printStackTrace();
		}
	}

	public static FdfsConnectionPool getInstance() {
		if (instance != null) {
			return instance;
		}
		synchronized (FdfsConnectionPool.class) {
			if (instance == null) {
				instance = new FdfsConnectionPool();
			}
			return instance;
		}
	}

	// 获取连接
	public StorageClient checkOut(int waitTime) {
		StorageClient storageClient = null;
		try {
			storageClient = idleConnectionPool.poll(waitTime, TimeUnit.SECONDS);
			if (storageClient != null) {
				busyConnectPool.put(storageClient, obj);
			}
		} catch (InterruptedException e) {
			storageClient = null;
			e.printStackTrace();
		}
		return storageClient;
	}

	// 回收连接
	public void checkIn(StorageClient storageClient) {
		if (busyConnectPool.remove(storageClient) != null) {
			idleConnectionPool.add(storageClient);
		}
	}

	// 如果连接无效则抛弃，新建连接来补充到池中
	public void drop(StorageClient storageClient) {
		if (busyConnectPool.remove(storageClient) != null) {
			TrackerClient trackerClient = new TrackerClient();
			TrackerServer trackerServer = null;
			StorageServer storageServer = null;
			StorageClient newStorageClient = null;
			try {
				trackerServer = trackerClient.getConnection();
				newStorageClient = new StorageClient(trackerServer, storageServer);
				idleConnectionPool.add(newStorageClient);
				System.out.println("------------------------- :connection +1");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (trackerServer != null) {
					try {
						trackerServer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
