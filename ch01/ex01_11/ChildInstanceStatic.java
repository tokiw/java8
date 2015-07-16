package ex01_11;

public class ChildInstanceStatic extends SInstance implements IStatic {
	public static void main(String[] args) { 
		new ChildInstanceStatic().f();
		IStatic.f();
	}
}
