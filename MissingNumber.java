package medium;

import java.util.ArrayList;
// import java.util.Collections;
import java.util.Random;

/*create an array of integers between 1 and 10 
 * (excluding one number, not sorted) 
 * and returns the missing number
 * */
// 20.11.2020
public class MissingNumber {

	public static void main(String[] args) {
		ArrayList<Integer> numArray = new ArrayList<Integer>();
		numArray = populateArray(numArray);
		findMissingNum(numArray);
	}

	// generate a random number
	public static int generateRandom() {
		// randomize a number between 1 to 10
		Random rand = new Random();
		int upperbound = 11;
		int lowerbound = 1;

		int randomNum = rand.nextInt(upperbound - lowerbound) + lowerbound;
		return randomNum;
	}

	// find the missing number in the array
	public static void findMissingNum(ArrayList<Integer> intArray) {
		// Array.contains() can find the missing number, sorted or unsorted
		// thus, sorting is not important here

		// System.out.println("\nOriginal Array Sorted");
		// Collections.sort(intArray);
		// System.out.println(intArray.toString());

		// find k which is not contained in the array
		for (int k = 1; k < 11; k++) {
			if (!intArray.contains(k)) {
				System.out.println("\nThe missing number = " + k);
			}
		}
	}

	// populate the array with random integer values 1 to 10
	public static ArrayList<Integer> populateArray(ArrayList<Integer> numArray) {
		int j = 0;

		while (j != 10) {
			int temp = generateRandom();
			// if the new integer is not in the list, add this number
			if (!numArray.contains(temp)) {
				numArray.add(temp);
				j++;
			}
		}
		// remove any one index in the array
		numArray.remove(generateRandom() - 1);

		// print the original array with one missing number
		System.out.println("Original Array");
		System.out.println(numArray.toString());
		return numArray;
	}
}
