package main;
/*
 * This code implements daemon threads.
 */
public class Thread_And_JVM {

	public static void main(String[] args) {
		Runnable lambda_runnable = () -> {
			while (true){
				try {
					// Pausing the thread for 1000 miliseconds or 1 seconds
					Thread.sleep(1000);
					System.out.println("Implementing thread using Runnable lambda expression");	
					// Getting thread name
					String lambda_thread_name = Thread.currentThread().getName();
					// Getting thread ID
					long lambda_thread_id = Thread.currentThread().threadId();
					// Getting thread priority
					int lambda_thread_priority = Thread.currentThread().getPriority();
					// Printing the thread name, ID and priority
					System.out.println("Thread Name:\t" + lambda_thread_name + "\nThread ID:\t" + lambda_thread_id + "\nThread Priority:\t" + lambda_thread_priority);
				} catch (InterruptedException ie) {
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
		try {
			// Pausing the thread for 3000 miliseconds or 3 seconds
			Thread.sleep(3000);
			// Getting thread name
			String thread_name = Thread.currentThread().getName();
			// Getting thread ID
			long thread_id = Thread.currentThread().threadId();
			// Getting thread priority
			int thread_priority = Thread.currentThread().getPriority();
			// Printing the thread name, ID and priority
			System.out.println("Thread Name:\t" + thread_name + "\nThread ID:\t" + thread_id + "\nThread Priority:\t" + thread_priority);
		} catch (InterruptedException ie) {
			System.out.println("Warning! Error encountered of interrupted exception type.\t" + ie);
			ie.printStackTrace();
		}
	}
}