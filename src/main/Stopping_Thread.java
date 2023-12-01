package main;
/*
 * This code shows how to stop a thread.
 */
public class Stopping_Thread implements Runnable{
	/*
	 * We are not using the Thread built-in stop method because it is deprecated and it will leave your
	 * application in inconsistent state as you don't at which line the thread has stopped.
	 */
	// Counter to stop the thread
	private boolean doStop = false;
	// Method to stop the thread by reinitializing the thread counter
	public synchronized void doStop() {
        this.doStop = true;
    }
	// Method to keep the thread running
	private synchronized boolean keepRunning() {
        return this.doStop == false;
    }
	// Overriding the run() method to specify the task to be done by the thread.
	@Override
	public void run() {
		 while(keepRunning()) {
	            // keep doing what this thread should do.
	            System.out.println("Running");

	            try {
	            	// Pausing the thread for 3000 miliseconds or 3 seconds
	                Thread.sleep(1000);
	            } catch (InterruptedException ie) {
	    			System.out.println("Warning! Error encountered of interrupted exception type.\t" + ie);
	    			ie.printStackTrace();
	            }
	        }
	}
	public static void main(String[] args) {
		Stopping_Thread stop_thread = new Stopping_Thread();
		Thread thread = new Thread (stop_thread, "Runnable lambda thread");
		thread.start();
		try {
        	// Pausing the thread for 5000 miliseconds or 5 seconds
            Thread.sleep(5000);
        } catch (InterruptedException ie) {
			System.out.println("Warning! Error encountered of interrupted exception type.\t" + ie);
			ie.printStackTrace();
        }
		System.out.println("Requesting to stop the thread");
		stop_thread.doStop();
	}
}