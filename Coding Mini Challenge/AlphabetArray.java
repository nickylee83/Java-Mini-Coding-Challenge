package medium;

import java.util.Arrays;

/* 
 * 20/11/2020 - Odoo Questions Q9
 * Write a function that returns an array
 * each element is a letter of the alphabet, from "A" to "Z"
 * (exactly once, in order and upper case).
 * Your code cannot contain the character ' (quote), " (double quote) or ` (back quote)
 * both regular and recursive versions

 * */
public class AlphabetArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printAlphabet();
		// print recursive array as a String
		char[] alpha = new char[26];
		String result = printAlphabetRecursive(alpha, alpha.length);
		System.out.println("\n" + result);

		// print recursive array as a char array (for a better print format
		// only)
		char[] array = result.toCharArray();
		System.out.println(Arrays.toString(array));
	}

	public static void printAlphabet() {
		// declare char array
		char[] alpha = new char[26];
		for (int i = 0; i < alpha.length; i++) {
			// A = 65 in ASCII
			alpha[i] = (char) (65 + i);
		}
		// print char array as a String (better print format)
		System.out.println(Arrays.toString(alpha));
		// another way of printing char array
		System.out.println(alpha);
	}

	public static String printAlphabetRecursive(char[] alpha, int index) {
		// if not a base case...
		if (index != 0) {
			// print out index numbers
			System.out.print(index + " ");
			// assign each char to array, in backward order
			alpha[index - 1] = (char) (91 - index);
			// return last index first, then subsequent index
			return alpha[index - 1] + printAlphabetRecursive(alpha, index - 1);
		}
		return "";
	}
}
