package ex01_11;

public class ChildInstanceAbstract extends SInstance implements IAbstract {
	public static void main(String[] args) {
		// SInstanceのf()
		new ChildInstanceAbstract().f();
	}
}
