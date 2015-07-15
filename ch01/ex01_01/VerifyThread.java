package ex01_01;

import java.util.Arrays;

/**
 * メソッド内で呼び出されるコンパレータのコードはsortメソッドを呼び出したスレッドで実行されている
 */
public class VerifyThread {
	public static void main(String[] args) {
		String[] strs = {"aaa", "bbb", "ccc"};
		System.out.println("Sort method called: " + Thread.currentThread().getName());
		Arrays.sort(strs, (first, second) -> {
			System.out.println("Comparator called: " + Thread.currentThread().getName());
			return first.compareTo(second);
		});
	}
}
