package filehandling;

import java.io.File;

public class RenameFiles {

	public static void main(String[] args) {
//		moveFile();
		File file = new File("sample folders/renamed.js");
		System.out.println((float)(file.length()/1024)   + "KB");
		String fileName = file.getName();
		System.out.println(
				fileName.substring(fileName.indexOf("."), fileName.length())
		);
		
	}

	private static void moveFile() {
		File file = new File("renamed.css");
		
		System.out.println(file.isFile());
		
		File file2 = new File("sample folders/renamed.js");
		
		file.renameTo(file2);
	}

}
