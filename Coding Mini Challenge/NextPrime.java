package medium;
// 26/11/2020

// find the next prime of the specified number

public class NextPrime {

	public static void main(String[] args) {
		System.out.println(nextPrime(504));
	}

	public static int nextPrime(int num) {
		// less than 2 ???, then, 2 is the next available prime
		if (num < 2) {
			return 2;
		}
		// divide by 2 to get less iterations
		int i = 2;
		while (i <= (num / 2)) {
			// if divided by i, it is not a prime
			if (num % i == 0) {
				// check next number start dividing by 2 to number/2 again
				num++;
				i = 2;
			}
			i++;
		}
		return num;
	}
}
