package ex05;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class FileReverse {
	public static void main(String[] args) throws IOException {
		byte[] bytes = Files.readAllBytes(Paths.get("ch09/ex05/in.txt"));
		byte[] reverseBytes = new byte[bytes.length];
		for (int i = 0; i < bytes.length; i++) {
			reverseBytes[bytes.length - 1 - i] = bytes[i];
		}
		Path path = new File("ch09/ex05/out.txt").toPath();
		Files.write(path, new byte[]{});
		Arrays.asList(reverseBytes).forEach(b -> {
			try {
				Files.write(path, b, StandardOpenOption.APPEND);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
