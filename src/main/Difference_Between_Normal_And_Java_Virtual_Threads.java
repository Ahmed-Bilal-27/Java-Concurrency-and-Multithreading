package main;
/*
 * This code highlights the difference between normal and virtual threads.
 * You can spawn thousands of virtual threads as they are lightweight as compared to normal
 * java threads.
 * For further reading plz refer to: https://jenkov.com/tutorials/java-concurrency/java-virtual-threads.html
 */
//====================Imports=================================
import java.util.ArrayList;
import java.util.List;
//====================Imports=================================
public class Difference_Between_Normal_And_Java_Virtual_Threads {
	public static void main(String[] args) {
		// Creating a list array of threads
		List<Thread> virtual_threads_list = new ArrayList<>();
		// Creating 100,000 java virtual threads. It is possible to create such large number of virtual
		// threads as they are lightweight
		for (int i = 0; i< 100_000; ++i) {
			int virtual_thread_index = i;
			Thread virtual_thread = Thread.ofVirtual().start(() ->{
				// Performing following calculation in each virtual thread
				int result = 1;
				for (int j = 0; j < 10; ++j) {
					result *= (j + 1);
				}
				System.out.println("Virtual Thread[ " + virtual_thread_index + " ] and result[ "+ result + " ]");
			});
			// Adding the virtual thread in array list of threads
			virtual_threads_list.add(virtual_thread);
		}
		for (int i = 0; i < virtual_threads_list.size(); ++i) {
			try {
				// main waiting for the java virtual thread to complete
				virtual_threads_list.get(i).join();
			} catch (InterruptedException ie) {
				System.out.println("Warning! Error encountered of interrupted exception type.\t" + ie);
				ie.printStackTrace();
			}
		}
	}
}