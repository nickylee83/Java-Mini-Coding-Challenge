package hard;

/**
 * 24/11/2020 takes an integer i and returns a string with the integer backwards
 * followed by the original integer
 */

public class IntReverseAndNot {

	public static void main(String[] args) {
		String result = reverseAndNot(987654321);
		System.out.println(result);
	}

	public static String reverseAndNot(int num) {
		// store original number before dividing
		int temp = num;
		String reverseString = "";

		// divide as long as we don't get a zero quotient
		while (num != 0) {
			// take the remainder in each iteration
			// store each remainder in a string
			reverseString += Integer.toString(num % 10);
			// keep dividing
			num = num / 10;
		}
		// concatenate with the original value
		reverseString += Integer.toString(temp);
		return reverseString;
	}

}
