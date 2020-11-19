package medium;

// 17/11/2020
// to count how many number of digits
public class CountIntegerDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int counter = countDigits(-123456);
		int countRecursive = countDigitsRec(-123456);
		System.out.println("Normal = " + counter);
		System.out.println("Recursive = " + countRecursive);
	}

	// normal/regular version
	public static int countDigits(int num) {
		int count = 0;
		while (num != 0) {
			System.out.println(num);
			// divided by 10 to shift one place in front
			// and count every time shifted, until we
			// reach zero at quotient
			num = num / 10;
			count++;
		}
		return count;
	}

	// recursive version
	public static int countDigitsRec(int num) {

		if (num != 0) {
			System.out.println(num);
			return 1 + (countDigitsRec(num / 10));
		}
		return 0;
	}

}
