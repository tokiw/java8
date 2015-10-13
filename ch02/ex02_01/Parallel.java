package ex02_01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Parallel {
	public static void main(String[] args) {
		try {
			String contents = new String(Files.readAllBytes(Paths.get("./ch02/ex02_01/alice.txt")), StandardCharsets.UTF_8);
			List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
			System.out.println(parallelCount(words));
			
			System.out.println(words.stream().filter(w ->  w.length() > 12).count());
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	public static int parallelCount(final List<String> words) {
		List<List<String>> segments = segment(words, 10);
		List<Thread> threads = new ArrayList<>();
		List<Counter> counters = new ArrayList<>();
		segments.stream().forEach(segment -> {
			Counter counter = new Counter(segment);
			counters.add(counter);
			threads.add(new Thread(counter));
		});
		threads.forEach(Thread::start);
		threads.forEach((thread) -> {
			try {
				thread.join();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return counters.stream().reduce(0, (l, r) -> l + r.getCount(), (l, r) -> l + r );
	}
	
	private static List<List<String>> segment(final List<String> words, int segmentSize) {
		List<List<String>> segments = new ArrayList<>();
		Iterator<String> iterator = words.iterator();
		List<String> segment = new ArrayList<>();
		while (true) {
			if (segment.size() == segmentSize) {
				segments.add(segment);
				// segment initialize
				segment = new ArrayList<>();
			}
			if (!iterator.hasNext()) {
				segments.add(segment);
				// segment initialize
				segment = new ArrayList<>();
				break;
			}
			segment.add(iterator.next());
		}
		return segments;
	}
	
	static class Counter implements Runnable {
		private long count = 0;
		private List<String> segment;
		
		public Counter(final List<String> segment) {
			this.segment = segment;
		}
		@Override
		public void run() {
			this.count = segment.stream().filter(w -> w.length() > 12).count();
		}
		
		public int getCount() {
			return Long.valueOf(count).intValue();
		}
	}
}
