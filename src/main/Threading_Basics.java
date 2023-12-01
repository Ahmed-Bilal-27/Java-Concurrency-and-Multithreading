package main;
/*
 * This code identifies various ways in which java threads can be created.
 */
public class Threading_Basics extends Thread implements Runnable{
	// Overriding the run() method to specify the task to be done by the thread.
	@Override
	public void run () {
		System.out.println("The thread is running");
		// Getting thread name
		String thread_name = Thread.currentThread().getName();
		// Getting thread ID
		long thread_id = Thread.currentThread().threadId();
		// Getting thread priority
		int thread_priority = Thread.currentThread().getPriority();
		try {
			// Pausing the thread for 10000 miliseconds or 10 seconds
			Thread.sleep(10000);
		} catch (InterruptedException ie) {
			System.out.println("Warning! Error encountered of interrupted exception type.\t" + ie);
			ie.printStackTrace();
		}
		// Printing the thread name, ID and priority
		System.out.println("Thread Name:\t" + thread_name + "\nThread ID:\t" + thread_id + "\nThread Priority:\t" + thread_priority);
	}

	public static void main(String[] args) {
		// Getting thread name
		String thread_name = Thread.currentThread().getName();
		// Getting thread ID
		long thread_id = Thread.currentThread().threadId();
		// Getting thread priority
		int thread_priority = Thread.currentThread().getPriority();
		// Printing the thread name, ID and priority
		System.out.println("Thread Name:\t" + thread_name + "\nThread ID:\t" + thread_id + "\nThread Priority:\t" + thread_priority);
		// Creating a thread_01
		Thread thread_01 = new Thread();
		// Starting a thread_01
		thread_01.start();
		// Creating a thread_02
		Thread thread_02 = new Thread();
		// Starting a thread_01
		thread_02.start();
		// Creating an object of the class which inherits thread class
		Threading_Basics thread_basics_01 = new Threading_Basics();
		// Starting a thread
		thread_basics_01.start();
		// Creating an object of the class which inherits thread class
		Threading_Basics thread_basics_02 = new Threading_Basics();
		// Starting a thread
		thread_basics_02.start();
		// Creating a thread by passing the object of the class that implements runnable interface and thread name in the Thread constructor
		Thread runnable_thread_01 = new Thread(new Threading_Basics(), "Runnable Thread_01");
		// Starting a thread
		runnable_thread_01.start();
		// Creating a thread by passing the object of the class that implements runnable interface and thread name in the Thread constructor
		Thread runnable_thread_02 = new Thread(new Threading_Basics(), "Runnable Thread_02");
		// Starting a thread
		runnable_thread_02.start();

		Runnable runnable_01 = new Runnable() {

			@Override
			public void run() {
				System.out.println("Implementing thread using Runnable anonymous method");
				// Getting thread name
				String thread_name = Thread.currentThread().getName();
				// Getting thread ID
				long thread_id = Thread.currentThread().threadId();
				// Getting thread priority
				int thread_priority = Thread.currentThread().getPriority();
				// Printing the thread name, ID and priority
				System.out.println("Thread Name:\t" + thread_name + "\nThread ID:\t" + thread_id + "\nThread Priority:\t" + thread_priority);				
			}
			
		};
		// Creating a thread by implementing Runnable anonymous method by passing runnable object and thread name as parameter to Thread constructor
		Thread anony_thread_01 = new Thread(runnable_01, "Anonymous Thread_01");
		// Starting a thread
		anony_thread_01.start();
		Runnable runnable_02 = new Runnable() {

			@Override
			public void run() {
				System.out.println("Implementing thread using Runnable anonymous method");
				// Getting thread name
				String thread_name = Thread.currentThread().getName();
				// Getting thread ID
				long thread_id = Thread.currentThread().threadId();
				// Getting thread priority
				int thread_priority = Thread.currentThread().getPriority();
				// Printing the thread name, ID and priority
				System.out.println("Thread Name:\t" + thread_name + "\nThread ID:\t" + thread_id + "\nThread Priority:\t" + thread_priority);				
			}
			
		};
		// Creating a thread by implementing Runnable anonymous method by passing runnable object and thread name as parameter to Thread constructor
		Thread anony_thread_02 = new Thread(runnable_02, "Anonymous Thread_02");
		// Starting a thread
		anony_thread_02.start();
		Runnable lambda_runnable = () -> {
			System.out.println("Implementing thread using Runnable lambda expression");	
			// Getting thread name
			String lambda_thread_name = Thread.currentThread().getName();
			// Getting thread ID
			long lambda_thread_id = Thread.currentThread().threadId();
			// Getting thread priority
			int lambda_thread_priority = Thread.currentThread().getPriority();
			try {
				// Pausing the thread for 5000 miliseconds or 5 seconds
				Thread.sleep(5000);
			} catch (InterruptedException ie) {
				System.out.println("Warning! Error encountered of interrupted exception type.\t" + ie);
				ie.printStackTrace();
			}
			// Printing the thread name, ID and priority
			System.out.println("Thread Name:\t" + lambda_thread_name + "\nThread ID:\t" + lambda_thread_id + "\nThread Priority:\t" + lambda_thread_priority);
		};
		// Creating a thread by implementing Runnable lambda expression and passing runnable object and thread name as parameter to Thread constructor
		Thread lambda_thread = new Thread(lambda_runnable, "Lambda Thread");
		// Starting a thread
		lambda_thread.start();
	}
}