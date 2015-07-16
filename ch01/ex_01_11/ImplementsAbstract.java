package ex_01_11;

public class ImplementsAbstract implements IAbstract, JAbstract {

	// IAbstract, JAbstractともにf()メソッドの実装はないのでどちらのf()メソッドの実装かはない
	@Override
	public void f() {}

}
