package ex03_09;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomComparator {
	public static void main(String[] args) {
		List<TestData> testData = new ArrayList<>();
		testData.add(new TestData("aaa", 4));
		testData.add(new TestData("eee", 2));
		testData.add(new TestData("ccc", 1));
		testData.add(new TestData("ddd", 5));
		testData.add(new TestData("bbb", 3));
		
		testData.sort(lexicographicComparator("name"));
		testData.stream().forEach( item -> {
			System.out.println(item.name + ": " + item.age);
		});
		
		System.out.println("------------------");
		
		testData.sort(lexicographicComparator("age"));
		testData.stream().forEach( item -> {
			System.out.println(item.name + ": " + item.age);
		});
	}
	
	public static <T> Comparator<T> lexicographicComparator(String...fieldNames) {
		return (first, second) -> {
			Object firstValue;
			Object secondValue;
			for (String fieldName : fieldNames) {
				try {
					Field firstField = first.getClass().getField(fieldName);
		            firstField.setAccessible(true);
		            firstValue = firstField.get(first);
		            Field secondField = second.getClass().getField(fieldName);
		            secondField.setAccessible(true);
		            secondValue = secondField.get(second);
				} catch (ReflectiveOperationException e) {
					e.printStackTrace();
					continue;
				}
	            if (firstValue != null && secondValue != null) {
                    @SuppressWarnings({ "unchecked", "rawtypes" })
					int compare =  ((Comparable) firstValue).compareTo(secondValue);
                    if (compare != 0) {
                    	return compare;
                    }
                }
			}
			return 0;
		};
	}
	
	public static class TestData {
		public String name;
		public int age;
		
		public TestData(String name, int age) {
			this.name = name;
			this.age = age;
		}
	}
}
