package info.sjd.service;

import java.util.Random;

public class Timer {

	public static void delay(int sec) {
		try {
			Thread.sleep(1000*sec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void randomDelay(int max) {
		Random random = new Random();
		try {
			Thread.sleep(1000*random.nextInt(max));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
