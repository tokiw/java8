package ex01_06;

public class Main {
	public static void main(String[] args) {
		Thread thread = new Thread(Unchecker.uncheck( () -> {
			while(true) {
				System.out.println("called");
				Thread.sleep(1000);
			}
		}));
		thread.start();
	}
}
