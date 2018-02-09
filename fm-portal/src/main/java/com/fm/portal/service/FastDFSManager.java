package com.fm.portal.service;

import java.io.IOException;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class FastDFSManager {

	public static final String FDFS_SERVER_IP = "172.16.73.10";
	public static final String FDFS_SERVER_PORT = "8888";
	private static String FDFS_CONFIG = "fastdfs/fdfs_client.conf";

	private static TrackerClient trackerClient;
	private static FastDFSManager instance;

	public static FastDFSManager getInstance() {
		if (instance != null) {
			return instance;
		}
		synchronized (FastDFSManager.class) {
			if (instance == null) {
				instance = new FastDFSManager();
			}
			return instance;
		}
	}

	public FastDFSManager() {
		try {
			ClientGlobal.init(FDFS_CONFIG);
			trackerClient = new TrackerClient();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

	public String[] upload(byte[] file_buff, String file_ext_name, NameValuePair meta_list[]) {
		TrackerServer trackerServer = null;
		StorageServer storageServer = null;
		StorageClient storageClient = null;
		try {
			trackerServer = trackerClient.getConnection();
			storageServer = trackerClient.getStoreStorage(trackerServer);
			storageClient = new StorageClient(trackerServer, storageServer);
			if (meta_list == null) {
				meta_list = new NameValuePair[] {};
			}
			String fileIds[] = storageClient.upload_file(file_buff, file_ext_name, meta_list);
			return fileIds;
		} catch (IOException | MyException e) {
			e.printStackTrace();
		} finally {
			if (storageServer != null) {
				try {
					storageServer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (trackerServer != null) {
				try {
					trackerServer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	// public void upload(String local_file, String file_ext_name, NameValuePair
	// meta_list[]) {
	// try {
	// TrackerServer trackerServer = tracker.getConnection();
	// StorageClient storageClient = new StorageClient(trackerServer,
	// storageServer);
	// if (meta_list == null) {
	// meta_list = new NameValuePair[] {};
	// }
	// String fileIds[] = storageClient.upload_file(local_file, file_ext_name,
	// meta_list);
	// System.out.println(fileIds.length);
	// System.out.println("组名：" + fileIds[0]);
	// System.out.println("路径: " + fileIds[1]);
	// } catch (IOException | MyException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// public byte[] download(String group, String groupPath) {
	// try {
	// TrackerServer trackerServer = tracker.getConnection();
	// StorageClient storageClient = new StorageClient(trackerServer,
	// storageServer);
	// byte[] b = storageClient.download_file(group, groupPath);
	// // IOUtils.write(b,
	// // new FileOutputStream("/Users/stallmandu/Documents/" +
	// // UUID.randomUUID().toString() + ".jpg"));
	// return b;
	// } catch (IOException | MyException e) {
	// e.printStackTrace();
	// }
	// return null;
	// }
	//
	// public void getFileMate(String group, String groupPath) {
	// try {
	// TrackerServer trackerServer = tracker.getConnection();
	// StorageClient storageClient = new StorageClient(trackerServer,
	// storageServer);
	// NameValuePair nvps[] = storageClient.get_metadata(group, groupPath);
	// for (NameValuePair nvp : nvps) {
	// System.out.println(nvp.getName() + ":" + nvp.getValue());
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	//
	// public void testDelete(String group, String groupPath) {
	// try {
	// TrackerServer trackerServer = tracker.getConnection();
	// StorageClient storageClient = new StorageClient(trackerServer,
	// storageServer);
	// int i = storageClient.delete_file(group, groupPath);
	// System.out.println(i == 0 ? "删除成功" : "删除失败:" + i);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
}
