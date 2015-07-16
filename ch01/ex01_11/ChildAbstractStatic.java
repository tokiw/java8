package ex01_11;

public class ChildAbstractStatic extends SAbstract implements IStatic {
	@Override
	public void f() {}
	
	public static void main(String[] args) {
		IStatic.f();
		new ChildAbstractStatic().f();
	}
}
