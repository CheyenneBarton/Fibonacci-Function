package cen3024;


/**
 * This program times an iterative and recursive thread to see what the runtime
 * efficiency of each are. long startTime and long endTime are used to find the nanoseconds.
 * @author Cheyenne Barton
 *
 */
public class Documentation_HW {

	/**
	 * This is the main method where the two threads are initialized
	 * and started.
	 * @param args Unused
	 */
	public static void main(String[] args) {
		ReThread reThread = new ReThread();
		ItThread itThread = new ItThread();

		itThread.start();
		reThread.start();
	}
}

/**
 * The Iterative Thread
 *@return int First 2 numbers are stored in v1 and v2. 
 *v3 will contain the Fibonacci number
 *@param Thread 
 *@see #v1(number)
 *@see #v2(number)
 *@see #v3(number)
 */
class ItThread extends Thread {
	public Integer n = 0;

	int fibonacci(int n) {
		int v1 = 0, v2 = 1, v3 = 0;

		for (int i = 2; i <= n; i++) {
			v1 = v2;
			v2 = v3;
			v3 = v1 + v2;
		}
		return v3;
	}
	
/**
 * This method runs the iterative thread by starting the time, inputting a number
 * and ending the time. It will then otuput the time it took for the iterative thread 
 * to find the answer in nanoseconds
 * @param none 
 * @see #n(fibonacci number)
 */
	public void run() {

		long startTime = System.nanoTime();

		n = fibonacci(9);

		long endTime = System.nanoTime();

		System.out.println("Iterative Thread found the answer: " + n + " in " + (endTime - startTime) + " nanoseconds");

	}

	}
/**
* The Recursive Thread
*@param Thread 
*@return int + int2 If numbers 0 and 1 are passed through, 0 and 1 will be outputted.
*If any numbers greater then 0 and 1 are passed through then the thread will add the 
*numbers and minus them by 1 and 2
*/

class ReThread extends Thread {
	public Integer n = 0;

	int fibonacci(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	/**
	 * This method runs the recursive thread by starting the time, inputting a number
	 * and ending the time. It will then otuput the time it took for the recursive thread 
	 * to find the answer in nanoseconds
	 * @param none 
	 * @see #n(fibonacci number)
	 */
	public void run() {
		
		long startTime = System.nanoTime();

		n = fibonacci(9);

		long endTime = System.nanoTime();

		System.out.println("Recursion Thread found the answer: " + n + " in " + (endTime - startTime) + " nanoseconds");
	}
	
}
