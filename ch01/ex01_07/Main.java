package ex01_07;

public class Main {

	public static void main(String[] args) {
		Thread th = new Thread( AndThen.andThen( () -> {
			for (int i=0; i < 3; i++) {
				System.out.println("first");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, () -> {
			for (int i=0; i < 2; i++) {
				System.out.println("second");
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}));
		th.start();
	}

}
