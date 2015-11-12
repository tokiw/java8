package ex11;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;

public class AuthPageLoader {
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.rnavi.com/rnavi/rstyle/shop/");
		URLConnection connection = url.openConnection();
		Base64.Encoder  encoder = Base64.getEncoder();
		String username = "rss";
		String password = "rnavi";
		String auth = username + ":" + password;
		String encoded = encoder.encodeToString(auth.getBytes(StandardCharsets.UTF_8));
		connection.setRequestProperty("Authorization", "Basic " + encoded);
		connection.connect();
		InputStream input = connection.getInputStream();
		
		try(Scanner scanner = new Scanner(input)) {
		    while (scanner.hasNextLine()) {
		        String line = scanner.nextLine();
		        System.out.println(line.toUpperCase());
		    }
		}
	}
}
