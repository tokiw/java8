package ex03;

import java.math.BigInteger;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Main {

	public static void main(String[] args) {
//		BigInteger b = new BigInteger("1234567890987654321");
//		System.out.println(b);
//		System.out.println(b.mod(BigInteger.TEN));
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("nashorn");
		try {
			Object result = engine.eval("function a() { return undefined; } a()");
			System.out.println(result);
		} catch (ScriptException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
