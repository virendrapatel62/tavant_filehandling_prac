package filehandling;

import java.io.File;

public class FileFIlterDemo {

	public static void main(String[] args) {
		String loc = "sample folders/a";

		File file = new File(loc);
		String extention = ".png";
		
		File[] files = file.listFiles((tempfile, name) -> name.toLowerCase().endsWith(extention.toLowerCase()));

		for (File f : files) {
			System.out.println(f);
		}
	}

}
