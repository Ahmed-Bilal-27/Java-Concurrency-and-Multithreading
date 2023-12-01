package main;
/*
 * This code implements join() method of thread which allow to wait for other threads to complete.
 */
public class Wait_For_Threads {

	public static void main(String[] args) {
		Runnable lambda_runnable = () -> {
			for (int i = 0; i < 5; ++i) {
				try {
					// Pausing the thread for 1000 miliseconds or 1 seconds
					Thread.sleep(1000);
					System.out.println("Thread is running");
				}
				catch (InterruptedException ie) {
					System.out.println("Warning! Error encountered of interrupted exception type.\t" + ie);
					ie.printStackTrace();
				}
			}
		};
		Thread thread = new Thread(lambda_runnable, "Runnable Lambda Expression");
		/*
		 * As long as any thread is running JVM (Java Virtual Machine) will keep running whether
		 * it is main thread or not. If you want to exit JVM as long as main thread exits then set
		 * all the other threads as daemon threads.
		 */
		thread.setDaemon(true);
		thread.start();
		/* If you comment the following code block you will notice that the JVM exits as soon as main
		 * thread exits because the above created thread is set as daemon thread.
		 * But if you uncomment the following code block you will see that because of join method
		 * now main thread calling join on the java thread will block for the java thread to complete.
		 * Therefore, JVM will keep running until both threads (main and java thread) terminate.
		 */
		try {
			// main waiting for the runnable thread to complete
			thread.join();
		} catch (InterruptedException ie) {
			System.out.println("Warning! Error encountered of interrupted exception type.\t" + ie);
			ie.printStackTrace();
		}
	}
}