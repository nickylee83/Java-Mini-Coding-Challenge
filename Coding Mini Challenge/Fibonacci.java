package medium;

// 17.11.2020
import java.lang.Math;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 39;
		int fiboRecursive = FiboRecursive(n);
		System.out.println("Fibo Recursive = " + fiboRecursive);
		showAllFibo();
		System.out.println("\n\n");

		int result = showFibonacciNum(n);
		System.out.println(n + "th term of Fibonacci number is " + result);
	}

	public static void showAllFibo() {
		int[] fiboArray = new int[40];
		// the first two elements are fixed values
		fiboArray[0] = 0;
		fiboArray[1] = 1;
		int k = 0;
		// the rest are... x = (x - 1) + (x - 2)
		for (int i = 2; i < fiboArray.length; i++) {
			fiboArray[i] = fiboArray[i - 1] + fiboArray[i - 2];
		}
		// display the array
		for (int j : fiboArray) {
			System.out.printf("\n%6d %2d", j, k++);
		}
	}

	// recursive version
	public static int FiboRecursive(int n) {
		// base case, 1 or less than 1 element
		if (n <= 1) {
			return n;
		}
		// x = (x - 1) + (x - 2)
		return (FiboRecursive(n - 1) + FiboRecursive(n - 2));
	}

	// alternative way of Fibonacci Array using formula
	public static int showFibonacciNum(int n) {

		double dbFibo = 0;
		// n = (x ^ n) - ((1 - x) ^ n) / square root(5)
		// where n is the nth term and x is the golden ratio constant
		dbFibo = (Math.pow(1.618033989, n) - Math.pow((1 - 1.618033989), n)) / Math.sqrt(5);
		// convert result (double) to integer
		return ((int) dbFibo);

	}
}
