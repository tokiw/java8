package ex04_05;

import java.util.function.BiFunction;
import java.util.function.Function;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Observer {

	public static <T, R> ObservableValue<R> observe(Function<T, R> f, ObservableValue<T> t) {
		ObservableValue<R> value = new ObservableValue<R>() {
			@Override
			public void addListener(InvalidationListener listener) {
				
			}

			@Override
			public void removeListener(InvalidationListener listener) {
			}

			@Override
			public void addListener(ChangeListener<? super R> listener) {
			}

			@Override
			public void removeListener(ChangeListener<? super R> listener) {
			}

			@Override
			public R getValue() {
				return f.apply(t.getValue());
			}
		};
		
		return value;
	}
	
	public static <T, U, R> ObservableValue<R> observe(BiFunction<T, U, R> f, ObservableValue<T> t, ObservableValue<U> u) {
		ObservableValue<R> value = new ObservableValue<R>() {
			@Override
			public void addListener(InvalidationListener listener) {
				
			}

			@Override
			public void removeListener(InvalidationListener listener) {
			}

			@Override
			public void addListener(ChangeListener<? super R> listener) {
			}

			@Override
			public void removeListener(ChangeListener<? super R> listener) {
			}

			@Override
			public R getValue() {
				return f.apply(t.getValue(), u.getValue());
			}
		};
		
		return value;
	}
}
