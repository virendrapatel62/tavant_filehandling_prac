package filehandling;

import java.io.File;

public class Main {

	public static void main(String[] args) {
//		absoluteFilePath();
//		relativePath();
//		deletefile();
		
		String folder = "sample folders";
		File file = new File(folder);
		if(file.isDirectory()) {
			System.out.println("Directory Exists");
			for(File f : file.listFiles()) {
				System.out.println(f);
				System.out.println(f.isDirectory());
				System.out.println(f.isFile());
			}
		}else {
			System.out.println("No Dir..");
		}
	}
	
	private static void deletefile() {
		String separator = System.getProperty("file.separator");
		System.out.println(separator);
		
		String relative = "somefile.txt";
		File file = new File(relative);
		System.out.println(file.getAbsolutePath());
		
		try {
			if(file.delete()) {
				System.out.println("File deleted..");
			}else {
				System.out.println("not deleted..");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	private static void relativePath() {
		String separator = System.getProperty("file.separator");
		System.out.println(separator);
		
//		String relative = "src"+separator+"somefile.txt";
		String relative = "../somefile.txt";
		System.out.println();
		File file = new File(relative);
		
		try {
			if(file.createNewFile()) {
				System.out.println("File Created..");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void absoluteFilePath() {
		String separator = System.getProperty("file.separator");
		System.out.println(separator);
		
		String absoluteFilePath = "D:"+separator+"somefile.txt";
		
		File file = new File(absoluteFilePath);
		
		try {
			if(file.createNewFile()) {
				System.out.println("File Created..");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
