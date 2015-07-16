package ex01_11;

public class ChildStatic extends SStatic implements IStatic {
	
	public static void main(String[] args) {
		SStatic.f();
		// SStaticと同じ
		ChildStatic.f();
		IStatic.f();
	}
}
