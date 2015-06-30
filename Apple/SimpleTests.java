package Apple;

import Apple.Logger.DMLogLevel;

public class SimpleTests {

	public static void main(String args[]) {
		if (Integer.parseInt(args[0]) == 1) {
			testMethod1();
		} else {
			testMethod2();
		}
	}

	static void testMethod1() {
		for (int i = 0; i < 100; ++i) {
			final int id = i;
			Thread one = new Thread() {
				public void run() {
					test2(id);
				}
			};
			one.start();
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Logger.stop();
	}

	static void testMethod2() {

		Thread one = new Thread() {
			public void run() {
				test2(234);
			}
		};

		Thread two = new Thread() {
			public void run() {
				test2(235);
			}
		};

		Thread three = new Thread() {
			public void run() {
				test2(236);
			}
		};
		one.start();
		two.start();
		three.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Logger.stop();
	}

	public static void test(int id) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String errorDetail = "Bad State";
		Logger.DMLog(DMLogLevel.DM_LOG_INFO, id
				+ " This is just an informative message");
		int state;
		state = 2;
		Logger.DMLog(DMLogLevel.DM_LOG_WARNING, id
				+ " In an unexpected State: %d", state);
		state = 3;
		Logger.DMLog(DMLogLevel.DM_LOG_ERROR, id
				+ " This is bad State: %d, Detail: %s", state, errorDetail);

	}

	public static void test2(int id) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String errorDetail = "Bad State";
		Logger.DMLog(DMLogLevel.DM_LOG_INFO, id
				+ " This is just an informative message");
		int state;
		state = 4;
		Logger.DMLog(DMLogLevel.DM_LOG_ERROR, id
				+ " This is bad State: %d, Detail: %s", state, errorDetail);
		state = 2;
		Logger.DMLog(DMLogLevel.DM_LOG_WARNING, id
				+ " In an unexpected State: %d", state);
		state = 3;
		Logger.DMLog(DMLogLevel.DM_LOG_ERROR, id
				+ " This is bad State: %d, Detail: %s", state, errorDetail);

	}
}
