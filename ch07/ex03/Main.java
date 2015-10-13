package ex03;

import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {
		BigInteger b = new BigInteger("1234567890987654321");
		System.out.println(b);
		System.out.println(b.mod(BigInteger.TEN));
	}

}
