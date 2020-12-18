package filehandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.Date;

public class CopyFile {

	public static void copyUsingJava7() throws Exception {
		File file = new File("newFile.exe");
		System.out.println(new Date().toLocaleString());
		Files.copy(file.toPath(), new File("newfile4.exe").toPath());
		System.out.println(new Date().toLocaleString());
	}

	public static void main(String[] args) throws Exception {
		
		copyUsingJava7();
//		traditionalMethod();
//		method2();
	}

	private static void method2() throws FileNotFoundException, IOException {
		File file = new File("newFile.exe");
		System.out.println(file.exists());

		System.out.println(new Date().toLocaleString());

		FileChannel src = null;
		FileChannel dest = null;

		src = new FileInputStream(file).getChannel();
		dest = new FileOutputStream("newFile3.exe").getChannel();

		dest.transferFrom(src, 0, src.size());
		System.out.println(new Date().toLocaleString());
		System.out.println("DOne....");
	}

	private static void traditionalMethod() {
		File file = new File("newFile.exe");

		System.out.println(file.exists());
		System.out.println(((float) (file.length() / (1024 * 1024))) + " MB");
		InputStream inputStream = null;
		OutputStream outputStream = null;

		try {
			inputStream = new FileInputStream(file);

			outputStream = new FileOutputStream("newFile2.exe");

			byte[] bytes = new byte[1024 * 1024 * 500];
			int length = 0;

			inputStream = new FileInputStream(file);
			System.out.println(new Date().toLocaleString());
			
			

			while ((length = inputStream.read(bytes)) > 0) {
				System.out.println("Written: " + length / (1024 * 1024) + " MB");
				outputStream.write(bytes, 0, length - 1);
			}

			System.out.println(new Date().toLocaleString());

			inputStream.close();
			outputStream.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.err.println("DOne...");
	}
}
