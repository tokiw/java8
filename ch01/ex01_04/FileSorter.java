package ex01_04;

import java.io.File;
import java.util.Arrays;

/**
 * Fileの配列をソート
 * ファイルの前にディレクトリ
 * 同じ種類だったらパス名でソート
 */
public class FileSorter {
	public static File[] sort(final File[] files) {
		Arrays.sort(files, (first, second) -> {
			if(isSameItem(first, second)) {
				return first.getAbsolutePath().compareTo(second.getAbsolutePath());
			} else {
				return first.isDirectory() ? -1 : 1;
			}
		});
		
		return files;
	}
	
	private static boolean isSameItem(File first, File second) {
		return first.isDirectory() == second.isDirectory();
	}
}
