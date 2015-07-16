package ex01_11;

public class ImplementsStaticAbstract implements IStatic, JAbstract {
	@Override
	public void f() {}
	
	public static void main(String[] args) {
		// JAbstractから継承し、ImplementsStaticAbstractで実装したf()
		new ImplementsStaticAbstract().f();
		
		// IStaticのstaticメソッドf()
		IStatic.f();
	}
}
