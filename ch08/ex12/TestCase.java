package ex12;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Repeatable(TestCases.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestCase {
	String params();
	String expected();
}

@Retention(RetentionPolicy.RUNTIME)
@interface TestCases {
	TestCase[] value();
}
