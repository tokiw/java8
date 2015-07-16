package ex_01_11;

public class ImplementsDefaultStatic implements IDefault, JStatic {
	
	public static void main(String[] args) {
		// IDefaultのデフォルトメソッドf()
		new ImplementsDefaultStatic().f();
		
		// JStaticのstaticメソッドf()
		JStatic.f();
	}
}
