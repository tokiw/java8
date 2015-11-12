package ex02;

public class Main {
	public static void main(String[] args) {
		// 普通の数字 -> 問題なし
		System.out.println(Math.negateExact(1));
		// 0 -> 問題なし
		System.out.println(Math.negateExact(0));
		// intの最大値 -> 問題なし
		System.out.println(Math.negateExact(Integer.MAX_VALUE));
		// intの最小値 -> ArithmeticException
		// 負の数の方が1つ多いので
		System.out.println(Math.negateExact(Integer.MIN_VALUE));
	}
}
