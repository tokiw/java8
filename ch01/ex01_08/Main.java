package ex01_08;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		test1();
		test2();
	}
	
	private static void test1() {
		String[] names = { "Peter", "Paul", "Mary" };
		List<Runnable> runners = new ArrayList<>();
		for (String name : names) {
			// nameは毎回作られる
			runners.add( () -> {
				// 各nameがキャプチャされる
				System.out.println(name);
			});
		}
		
		for (Runnable runner: runners) {
			new Thread(runner).start();
		}
	}
	
	private static void test2() {
		String[] names = { "Peter", "Paul", "Mary" };
		List<Runnable> runners = new ArrayList<>();
		for (int i=0; i < names.length; i++) {
			runners.add( () -> {
				// int iがfinalでないので参照できない
//				System.out.println(names[i]);
			});
		}
		
		for (Runnable runner: runners) {
			new Thread(runner).start();
		}
	}
}
