package filehandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Date;

public class CopyTextFile {

	
	public static void main(String[] args) throws Exception{
		
		System.out.println(new Date().toLocaleString());
		long start = System.nanoTime();
		StringBuilder builder = new StringBuilder();
		BufferedReader bufferedReader = new BufferedReader(
				new FileReader(new File("Data7602DescendingYearOrder.csv"))
				);
		
		String line = null ;
//		while ((line = bufferedReader.readLine()) != null ) {
////			System.out.println(line);
//		}
		char[] chars = new char[1000];
		while ((bufferedReader.read(chars)) != -1 ) {
			builder.append(chars);
			chars = new char[1000];
		}
		
//		System.out.println(builder.toString());
		long end = System.nanoTime();
		System.out.println(new Date().toLocaleString());
		System.out.println((end-start ) + " NS");
	}

}
