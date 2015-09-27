package ex06_07;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapUtil {
	
	private ConcurrentHashMapUtil() {} 
	
	public static String getMaxValue(ConcurrentHashMap<String, Long> map) {
		return map.reduceEntries(1,	(item1, item2) -> {
			return item1.getValue() > item2.getValue() ? item1 : item2;
		}).getKey();
	}
}
