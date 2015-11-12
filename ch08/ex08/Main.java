package ex08;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) {
		Queue<Path> uncheckedQueue = new LinkedList<>();
		uncheckedQueue.add(Paths.get("path"));
		System.out.println(uncheckedQueue.poll());
		getMoreWork(uncheckedQueue);
		try {
			Files.isReadable(uncheckedQueue.poll());
		} catch(ClassCastException e) {
			e.printStackTrace();
		}
		Queue<Path> checkedQueue = Collections.checkedQueue(uncheckedQueue, Path.class);
		checkedQueue.add(Paths.get("path"));
		System.out.println(checkedQueue.poll());
		// checkedQueueの場合getMoreWork内でaddしたときにClassCastExceptionを出力
		getMoreWork(checkedQueue);
		Files.isReadable(checkedQueue.poll());
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" }) 
	public static void getMoreWork(Queue q) {
		q.add("string");
	}
}
