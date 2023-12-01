package main;
/*
 * This code shows how to create Java Virtual Threads.
 * Java virtual threads - executed by platform threads - which are again executed by OS threads.
 * While a platform thread can only execute a single virtual thread at a time, it has the ability
 * to switch to executing a different virtual thread when the currently executed virtual thread makes
 * a blocking call (e.g. network or concurrency data structure).
 * For further reading please refer to https://jenkov.com/tutorials/java-concurrency/java-virtual-threads.html
 */
public class Java_Virtual_Threads {
	public static void main (String[] args) {
		Runnable lambda_virtual_runnable = () -> {
			System.out.println("Implementing thread using Runnable lambda expression");	
			// Getting thread name
			String lambda_virtual_thread_name = Thread.currentThread().getName();
			// Getting thread ID
			long lambda_virtual_thread_id = Thread.currentThread().threadId();
			// Getting thread priority
			int lambda_virtual_thread_priority = Thread.currentThread().getPriority();
			try {
				// Pausing the thread for 5000 miliseconds or 5 seconds
				Thread.sleep(5000);
				for (int i = 0; i < 5; ++i) {
					System.out.println("At for loop index:\t" + i);
				}
			} catch (InterruptedException ie) {
				System.out.println("Warning! Error encountered of interrupted exception type.\t" + ie);
				ie.printStackTrace();
			}
			// Printing the thread name, ID and priority
			System.out.println("Thread Name:\t" + lambda_virtual_thread_name + "\nThread ID:\t" + lambda_virtual_thread_id + "\nThread Priority:\t" + lambda_virtual_thread_priority);
		};
		// Creating a virtual thread by implementing Runnable lambda expression and passing runnable object and starting it
		Thread lambda_virtual_thread = Thread.ofVirtual().start(lambda_virtual_runnable);
		// Creating a virtual thread by implementing Runnable lambda expression and passing runnable object
		Thread lambda_virtual_thread_unstarted = Thread.ofVirtual().unstarted(lambda_virtual_runnable);
		// Starting virtual thread
		lambda_virtual_thread_unstarted.start();
		try {
			// main waiting for the runnable thread to complete
			lambda_virtual_thread.join();
			lambda_virtual_thread_unstarted.join();
		} catch (InterruptedException ie) {
			System.out.println("Warning! Error encountered of interrupted exception type.\t" + ie);
			ie.printStackTrace();
		}
	}
}