package ex_01_11;

public class ImplementsDefaultAbstarct implements IDefault, JAbstract {
	// 定義しないとエラーになった。競合するから曖昧さを解消する必要がある??
	public void f() {};
}
