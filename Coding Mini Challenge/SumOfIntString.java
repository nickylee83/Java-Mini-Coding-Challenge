package medium;

/*
 * 20/11/2020
 * To find the sum of integer values
 * in a mixed type array of String and Integer
 * Both regular and recursive versions
 * */
public class SumOfIntString {

	public static void main(String[] args) {

		String[] numArray = { "abc", "123", "def", "-456" };

		int sum = addSum(numArray);
		int recSum = addSumRecursive(numArray, numArray.length);

		System.out.println("\nSum of the mixed-type array is = " + sum);
		System.out.println("Sum of the mixed-type array recursive is = " + recSum);
	}

	// regular version
	public static int addSum(String[] mixedArray) {
		int sum = 0;
		for (int i = 0; i < mixedArray.length; i++) {
			try {
				// if valid integer, add to the sum
				sum += Integer.parseInt(mixedArray[i]);
			} catch (NumberFormatException e) {
				// if not valid, skip this element
			}
		}
		return sum;
	}

	// recursive version
	public static int addSumRecursive(String[] mixedArray, int index) {
		int sum = 0;
		// not base case...
		if (index != 0) {
			try {
				// print out the index
				System.out.print(index + " ");
				// convert to integer, add the last item with the subsequent
				// items
				sum += Integer.parseInt(mixedArray[index - 1]) + addSumRecursive(mixedArray, index - 1);
				// not a valid number, but the index still need to go on
			} catch (NumberFormatException e) {
				sum += addSumRecursive(mixedArray, index - 1);
			}
			return sum;
		}
		// base case, return 0
		return 0;
	}
}
