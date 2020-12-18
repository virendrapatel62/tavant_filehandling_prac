package filehandling;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

public class Permission {
	public static void main(String[] args) throws IOException {
		
		File file = new File("D:/a.txt");
		System.out.println(file.getCanonicalPath());
//		System.out.println(file.getAbsolutePath());
		
		
		Set<PosixFilePermission> filePermissions = new HashSet<PosixFilePermission>();
		filePermissions.add(PosixFilePermission.GROUP_READ);
		filePermissions.add(PosixFilePermission.GROUP_WRITE);
		
		Set isPosix =
			    FileSystems.getDefault().supportedFileAttributeViews();
		
		System.out.println(isPosix);
		
//		Files.setPosixFilePermissions(Paths.get("file.txt"), filePermissions);
		
//		file.setReadOnly();
//		file.setWritable(true);
//		System.out.println(file.setReadable(true , false));
		
//		System.out.println(file.canRead());
		
		
	}
}
