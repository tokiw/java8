package ex06;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.ListIterator;

public class FileReverse {
	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get("ch09/ex06/in.txt"));
		Path path = new File("ch09/ex06/out.txt").toPath();
		Files.write(path, new byte[]{});
		for (ListIterator<String> it = lines.listIterator(lines.size()); it.hasPrevious();) {
			String line = it.previous() + "\n";
			Files.write(path, line.getBytes(), StandardOpenOption.APPEND);
		}
	}
}
