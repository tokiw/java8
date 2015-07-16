package ex_01_11;

public class ImplementsStatic implements IStatic, JStatic {
	
	public static void main(String[] args) {
		IStatic.f();
		JStatic.f();
	}
}
