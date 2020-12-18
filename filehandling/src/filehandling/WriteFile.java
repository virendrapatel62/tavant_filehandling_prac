package filehandling;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class WriteFile {
	private static List<String> filesInDir = new ArrayList<String>();
	
	public static void populateFileList(File dir) throws Exception {
		File[] files = dir.listFiles();
		
		for (File file : files) {
			if(file.isFile()) {
				filesInDir.add(file.getCanonicalPath());
			}else {
				populateFileList(file);
			}
		}
	}
	public static void main(String[] args) throws Exception {
//		fileWriting();
//		appendFIle();
//		writeImageFileUsingCharStream();
//		binaryFileCopyUsingFiles();
//		copyImageUsingFileInputOutputStream();
//		randomAccessDemo();

		
		String zipName = "D:/myfile.zip";
		populateFileList(new File("D:/sample folders"));
		FileOutputStream fileOutputStream = new FileOutputStream(zipName);
		ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
		
		
		
		for (String fileToZip : filesInDir) {
			System.out.println(fileToZip);
			ZipEntry entry = new ZipEntry(fileToZip);
			zipOutputStream.putNextEntry(entry);
			
			FileInputStream fileInputStream = new FileInputStream(fileToZip);
			byte[] buffer = new byte[1024] ;
			
			int len;
            while ((len = fileInputStream .read(buffer)) > 0) {
                zipOutputStream.write(buffer, 0, len);
            }
			
			fileInputStream.close();
			
		}
		zipOutputStream.closeEntry();
		
		zipOutputStream.close();
		
		System.out.println("DOne...");

	}
	
	

	private static void randomAccessDemo()  throws Exception{
		 RandomAccessFile accessFile = new RandomAccessFile("random.txt", "rw");
		// accessFile.seek(0);

		// accessFile.writeInt(1234);
		// accessFile.writeUTF("Virendra");
		//
		System.out.println(accessFile.readInt());
		System.out.println(accessFile.readUTF());

		accessFile.close();
	}

	private static void copyImageUsingFileInputOutputStream() throws FileNotFoundException, IOException {
		FileInputStream fileInputStream = new FileInputStream(new File("A.png"));
		FileOutputStream fileOutputStream = new FileOutputStream(new File("C.png"));

		int i;
		while ((i = fileInputStream.read()) != -1) {
			fileOutputStream.write(i);
		}

		fileInputStream.close();
		fileInputStream.close();

		System.out.println("DOne..");
	}

	private static void binaryFileCopyUsingFiles() throws FileNotFoundException, IOException {

		byte[] bytes = Files.readAllBytes(Paths.get("A.png"));
		Files.write(Paths.get("B.png"), bytes);
	}

	private static void writeImageFileUsingCharStream() throws FileNotFoundException, IOException {
		FileReader fileReader = new FileReader(new File("A.png"));
		FileWriter fileWriter = new FileWriter(new File("B.png"));
		int i;
		while ((i = fileReader.read()) != -1) {
			fileWriter.write(i);
			System.out.println(i);
		}

		fileWriter.close();
		fileReader.close();
		System.out.println("DOne..");
	}

	private static void appendFIle() throws IOException {
		String str = Files.readString(Paths.get("file.txt"));
		System.out.println(str);

		String lineSep = System.getProperty("line.separator");

		FileWriter fileWriter = new FileWriter(new File("append.txt"), true);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

		bufferedWriter.write(str + lineSep);

		bufferedWriter.close();
		fileWriter.close();
	}

	private static void fileWriting() throws IOException {
		String str = Files.readString(Paths.get("file.txt"));
		System.out.println(str);

//		method 1
//		Files.writeString(Paths.get("abcnew.txt"), str );

//		method2
//		Files.write(Paths.get("byte.txt"), str.getBytes());

//		method 3
//		FileWriter fileWriter = new FileWriter(new File("somefile"));
//		fileWriter.write(str.toCharArray());
//		fileWriter.close();

//		method4
//		System.out.println(">"+System.getProperty("line.separator")+"<");
//		FileWriter fileWriter = new FileWriter(new File("buffer.txt"));
//		BufferedWriter bufferedWriter  = new BufferedWriter(fileWriter);
//		bufferedWriter.write(str);
//		bufferedWriter.close();
//		fileWriter.close();
	}

}
