package ex16;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) {
		List<String> address = Arrays.asList(
			"Ebina, Kanagawa, 12345",
			"Ota, Tokyo, 123456789"
		);
		
		Pattern pattern = Pattern.compile("(?<city>[\\p{L}]+),\\s*(?<state>[\\p{L}]+),\\s*(?<zip>[0-9]{5}|[0-9]{9})");
		address.stream().map(pattern::matcher).filter(Matcher::matches).forEach(m -> {
			System.out.println(m.group("city")+ ": " + m.group("state") + ": " + m.group("zip"));
		});
	}
}
