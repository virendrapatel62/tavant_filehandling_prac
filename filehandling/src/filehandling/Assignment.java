package filehandling;

import java.io.File;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;

public class Assignment {

	public static void main(String[] args) {
		File folder = new File("sample folders");
		
//		usingConsumer(folder);
//		usingFunctionInterface(folder);
		
//		copyUsingExternalJar(new File("sample folders/abc.txt"), new File("./abcnew.txt"));
	}



	private static void copyUsingExternalJar(File src , File dest) {
		try {
			FileUtils.copyFile(src , dest);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	private static void usingConsumer(File folder) {
		Consumer<File>  consumer = new Consumer<File>() {
			@Override
			public void accept(File file) {
				if(file.isDirectory())
					Stream.of(file.listFiles()).forEach(f->accept(f));
				else
					file.delete();
			}
		};
		
		consumer.accept(folder);
	}

	private static void usingFunctionInterface(File folder) {
		Function<File,Void> deleteFiles = new Function<File, Void>() {
			@Override
			public Void apply(File file) {
				if(file.isDirectory())
					Stream.of(file.listFiles()).forEach(f->apply(f));
				else
					file.delete();
				
				return null;
			}
		};
		
		deleteFiles.apply(folder);
	}
	
}
