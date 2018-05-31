package org.csource;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class FastDFSClient {

	private static final String CONFIG_FILENAME = "src/main/resources/fdfs_client.conf";

	public static void testUpload(String file) {

		try {
			ClientGlobal.init(CONFIG_FILENAME);

			TrackerClient tracker = new TrackerClient();
			TrackerServer trackerServer = tracker.getConnection();
			StorageServer storageServer = null;

			StorageClient storageClient = new StorageClient(trackerServer, storageServer);
			// NameValuePair nvp = new NameValuePair("age", "18");
			NameValuePair nvp[] = new NameValuePair[] { new NameValuePair("age", "18"),
					new NameValuePair("sex", "male") };
			String fileIds[] = storageClient.upload_file(file, "png", nvp);

			System.out.println(fileIds.length);
			System.out.println("组名：" + fileIds[0]);
			System.out.println("路径: " + fileIds[1]);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
}
