package ex03_03;

import java.util.Objects;
import java.util.function.BooleanSupplier;

// ラムダ式を使えないとアサーションしない場合においてもconditionを評価してしまう。
public class Assertion {
	
	private static boolean isAssertion = false;
	
	public static void assertIf(BooleanSupplier condition, String message) throws NullPointerException {
		Objects.requireNonNull(condition);
		if (isAssertion && condition.getAsBoolean()) {
			throw new AssertionError();
		}
	}
}
