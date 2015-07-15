package ex01_07;

public class AndThen {

	public static Runnable andThen(Runnable first, Runnable second) {
		return () -> {
			first.run();
			second.run();
		};
	}
}
