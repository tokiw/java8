package ex07;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Main {
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.google.com");
		InputStream stream = url.openStream();
		Path path = new File("ch09/ex07/out.txt").toPath();
		Files.write(path, new byte[]{});
		Files.copy(stream, path, StandardCopyOption.REPLACE_EXISTING);
	}
}
