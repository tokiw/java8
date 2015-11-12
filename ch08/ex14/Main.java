package ex14;

import java.util.Objects;

public class Main {
	Integer value;
	
	public static void main(String[] args) {
		new Main().set(null);
	}
	
	public void set(Integer val) {
		Objects.requireNonNull(val, "expected nonNull value");
		this.value = val;
	}
}
