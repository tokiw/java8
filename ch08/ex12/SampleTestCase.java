package ex12;

import java.util.Arrays;

public class SampleTestCase {
	
	public static void main(String[] args) {
		Arrays.asList(SampleTestCase.class.getMethods()).stream().filter(m -> m.isAnnotationPresent(TestCase.class) || m.isAnnotationPresent(TestCases.class)).forEach(m -> {
			Arrays.asList(m.getAnnotationsByType(TestCase.class)).forEach(a -> {
				try {
					Object instance = m.getDeclaringClass().newInstance();
					String params = a.params();
					String expected = a.expected();
					String result = (String)m.invoke(instance, params);
					System.out.print(m.getName() + ": " + "params: " + params + ", expected: " + expected + ", result: ");
					System.out.println(result.equals(expected) ? "OK" : "NG" );
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		});
	}
	
	@TestCase(params="Hello", expected="Hello")
	@TestCase(params="Hello", expected="world")
	public String repeat(String str) {
		return str;
	}
	
	public int repeat(int val) {
		return val;
	}
}
