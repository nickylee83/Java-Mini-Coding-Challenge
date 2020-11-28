package medium;

// 28/11/2020
// to find the duplicate chars and count the max frequency
import java.util.HashMap;

public class DuplicateChar {

	public static void main(String[] args) {

		String result = countDuplicateChar("The maximum frequency of duplicate character is the maximum value");
		System.out.println("The maximum frequency of duplicate character is " + result);
	}

	public static String countDuplicateChar(String myString) {
		// every char starts at least one occurrence
		int counter = 1;
		char ch;
		int maxCount = 0;
		char dupChar = ' ';

		// use hash map <key, value> key is char and value is counter
		HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
		for (int i = 0; i < myString.length(); i++) {
			// take every char in the string
			ch = myString.charAt(i);
			// if we found that same char again....
			if (hash.containsKey(ch)) {
				counter = hash.get(ch);
				counter++;
				// replace with new counter
				hash.replace(ch, counter);
			} else {
				// not found? just put counter as one
				hash.put(ch, 1);
			}
		}
		for (Character key : hash.keySet()) {
			// read the array and display each char and counter
			System.out.println(key + " = " + hash.get(key));
			// we are not interested in how many space chars we have
			if (key != ' ') {
				// which char has the maximum count value?....
				if (hash.get(key) > maxCount) {
					maxCount = hash.get(key);
					dupChar = key;
				}
			}
		}
		return (dupChar + " = " + maxCount);
	}
}
