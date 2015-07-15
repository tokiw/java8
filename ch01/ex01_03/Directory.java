package ex01_03;

import java.io.File;

/**
 * キャプチャされる変数: extension
 */
public class Directory {
	public static String[] getAllSubFiles(String path, String extension) {
		File directory = new File(path);
		return directory.list( (file, filename) -> {
			// extension = "java"; error
			return filename.contains("." + extension);
		});
	}
}
