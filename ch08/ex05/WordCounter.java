package ex05;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;

public class WordCounter {
	
	public static void main(String[] args) throws IOException {
		String contents = new String(Files.readAllBytes(Paths.get("./ch08/ex05/alice.txt")), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
		System.out.println(timeCountByFilter(words));
		System.out.println(timeCountByForEach(words));
	}
	
	public static int timeCountByFilter(List<String> words) {
		Instant start = Instant.now();
		long wordCount = words.stream().filter(w -> w.length() > 12).count();
		Instant end = Instant.now();
		System.out.println("words: " + wordCount);
		return Duration.between(start, end).getNano();
	}
	
	public static int timeCountByForEach(List<String> words) {
		LongAdder wordCount = new LongAdder();
		Instant start = Instant.now();
		words.forEach(w -> {
			if( w.length() > 12 ) {
				wordCount.increment();;
			}
		});
		Instant end = Instant.now();
		System.out.println("words: " + wordCount.intValue());
		return Duration.between(start, end).getNano();
	}
}
