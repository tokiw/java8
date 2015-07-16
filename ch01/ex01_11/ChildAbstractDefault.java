package ex01_11;

public class ChildAbstractDefault extends SAbstract implements IDefault {
	@Override
	public void f() {
		// 以下のように実装すればIDefaultのf()を使える
		IDefault.super.f();
	}
}
