package medium;

// 15.11.2020
public class RecSumArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] myArray = { 1, 4, 5, 7 };

		System.out.println("Sum of array = " + sumArray(myArray, myArray.length));
	}

	public static int sumArray(int[] arr, int index) {

		if (index != 0) {
			// check the output on each iteration
			System.out.println(arr[index - 1]);
			// add the last element and the subsequent elements until it reaches
			// the first one
			return arr[index - 1] + sumArray(arr, index - 1);
		}
		// base case
		return 0;
	}

}
