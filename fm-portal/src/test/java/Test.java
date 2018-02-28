import java.text.ParseException;

import org.csource.fastdfs.StorageClient;

import com.fm.portal.util.fdfs.FdfsConnectionPool;

public class Test {

	public static void main(String[] args) throws ParseException {
		StorageClient s1 = FdfsConnectionPool.getInstance().checkOut(10);
	}

}
