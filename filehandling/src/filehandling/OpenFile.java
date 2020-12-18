package filehandling;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class OpenFile {

	public static void main(String[] args) throws IOException {
		File file = new File("sample folders");
		
		if(!Desktop.isDesktopSupported()) {
			System.err.println("Not supported...");
		}else {
			Desktop desktop = Desktop.getDesktop();
			
			if(file.exists()) {
				desktop.open(file);
			}else {
				System.err.println("file not available..");
			}
		}
	}

}
