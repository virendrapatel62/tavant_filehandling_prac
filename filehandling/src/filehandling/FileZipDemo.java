package filehandling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileZipDemo {

	public static void main(String[] args) {
		zip();
		System.out.println("DOne");
	}

	public static void zip() {
		String zipFileName = "D:\\myzip.zip";

		String folder = "./";

		try {
			Path zipFile = Files.createFile(Paths.get(zipFileName));
			Path sourceDir = Paths.get(folder);
			try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile))) {

				Stream<Path> paths = Files.walk(sourceDir);

				paths.filter(path -> !Files.isDirectory(path)).forEach(path -> {
					ZipEntry zipEntry = new ZipEntry(sourceDir.relativize(path).toString());
					try {
						zipOutputStream.putNextEntry(zipEntry);
						Files.copy(path, zipOutputStream);
						zipOutputStream.closeEntry();
					} catch (IOException e) {
						System.err.println(e);
					}
				});

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
