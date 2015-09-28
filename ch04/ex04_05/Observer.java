package ex04_05;

import java.util.function.BiFunction;
import java.util.function.Function;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableValue;

public class Observer {

	public static <T, R> ObservableValue<R> observe(Function<T, R> f, ObservableValue<T> t) {
		return Bindings.createObjectBinding(() -> f.apply(t.getValue()), t);
//		return new ObservableValue<R>() {
//			@Override
//			public void addListener(InvalidationListener listener) {
//				t.addListener(listener);
//			}
//
//			@Override
//			public void removeListener(InvalidationListener listener) {
//				t.addListener(listener);
//			}
//
//			@Override
//			public void addListener(ChangeListener<? super R> listener) {
//			}
//
//			@Override
//			public void removeListener(ChangeListener<? super R> listener) {
//			}
//
//			@Override
//			public R getValue() {
//				System.out.println(t.getValue());
//				return f.apply(t.getValue());
//			}
//		};
	}
	
	public static <T, U, R> ObservableValue<R> observe(BiFunction<T, U, R> f, ObservableValue<T> t, ObservableValue<U> u) {
		return Bindings.createObjectBinding(() -> f.apply(t.getValue(), u.getValue()), t, u);
//		return new ObservableValue<R>() {
//			@Override
//			public void addListener(InvalidationListener listener) {
//				t.addListener(listener);
//				u.addListener(listener);
//			}
//
//			@Override
//			public void removeListener(InvalidationListener listener) {
//				t.removeListener(listener);
//				u.removeListener(listener);
//			}
//
//			@Override
//			public void addListener(ChangeListener<? super R> listener) {
//			}
//
//			@Override
//			public void removeListener(ChangeListener<? super R> listener) {
//			}
//
//			@Override
//			public R getValue() {
//				return f.apply(t.getValue(), u.getValue());
//			}
//		};
	}
}
