package info.sjd.model;

public class Timer {
	public static void delay(int sec) {
		try {
			Thread.sleep(1000*sec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
