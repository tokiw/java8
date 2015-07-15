package ex01_02;

import java.io.File;

public class Directory {
	public static File[] getSubDirectory(String path) {
		File directory = new File(path);
		return directory.listFiles( (file) -> {
			return file.isDirectory();
		});
	}
	
	public static File[] getSubDirectory2(String path) {
		File directory = new File(path);
		return directory.listFiles(File::isDirectory);
	}
}
