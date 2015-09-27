package ex06_01;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class LongestStringManager {
	final private AtomicReference<String> logestString;
	
	public LongestStringManager() {
		logestString = new AtomicReference<String>();
	}
	
	
	public LongestStringManager(String str) {
		logestString = new AtomicReference<String>(str);
	}
	
	public void setIfLonger(String newStr) {
		logestString.updateAndGet(oldStr -> {
			if (Objects.isNull(oldStr)) {
				return newStr;
			}
			if (oldStr.length() < newStr.length()) {
				return newStr;
			} else {
				return oldStr;
			}
		});
	}
	
	public String get() {
		return logestString.get();
	}
}
