package ex09;

import java.util.Iterator;
import java.util.PrimitiveIterator;
import java.util.Scanner;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ScannerConverter {
	
	public static Stream<String> lineStream(Scanner scanner) {
		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
                new Iterator<String>() {
					@Override
					public boolean hasNext() {
						return scanner.hasNextLine();
					}
					@Override
					public String next() {
						return scanner.nextLine();
					}
                }, Spliterator.ORDERED | Spliterator.NONNULL), false);
	}
	
	public static Stream<String> wordStream(Scanner scanner) {
		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
                new Iterator<String>() {
					@Override
					public boolean hasNext() {
						return scanner.hasNext();
					}
					@Override
					public String next() {
						return scanner.next();
					}
                }, Spliterator.ORDERED | Spliterator.NONNULL), false);
	}

	public static IntStream intStream(Scanner scanner) {
		return StreamSupport.intStream(Spliterators.spliteratorUnknownSize(
                new PrimitiveIterator.OfInt() {
					@Override
					public boolean hasNext() {
						return scanner.hasNextInt();
					}
					
					@Override
					public int nextInt() {
						return scanner.nextInt();
					}
				}, Spliterator.ORDERED | Spliterator.NONNULL), false);
	}

	public static DoubleStream doubleStream(Scanner scanner) {
		return StreamSupport.doubleStream(Spliterators.spliteratorUnknownSize(
                new PrimitiveIterator.OfDouble() {
					@Override
					public boolean hasNext() {
						return scanner.hasNextDouble();
					}
					
					@Override
					public double nextDouble() {
						return scanner.nextDouble();
					}
				}, Spliterator.ORDERED | Spliterator.NONNULL), false);
	}
	
	public static void main(String[] args) {
		System.out.println("LineStream");
		ScannerConverter.lineStream(createScanner()).forEach(System.out::println);
		System.out.println("WordStream");
		ScannerConverter.wordStream(createScanner()).forEach(System.out::println);
		System.out.println("IntStream");
		ScannerConverter.intStream(createScanner()).forEach(System.out::println);
		System.out.println("DoubleStream");
		ScannerConverter.doubleStream(createScanner()).forEach(System.out::println);
	}
	
	public static Scanner createScanner() {
		return new Scanner("1 2 3 \n4 5 6");
	}
}
