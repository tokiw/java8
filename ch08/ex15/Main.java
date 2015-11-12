package ex15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) throws IOException {
		Files.lines(Paths.get("ch08/ex15/sample.txt")).filter(Pattern.compile("^ab").asPredicate()).forEach(System.out::println);
	}
}
