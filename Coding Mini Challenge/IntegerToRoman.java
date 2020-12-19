package hard;
/* 13.12.2020
 * 
 * Convert an integer to a Roman numeral
 * Your Roman numeral should be a string type
 * Assume only positive integer (1 to 3,999) should be entered */

public class IntegerToRoman {

	public static void main(String[] args) {
		int num = 2674;
		System.out.println(num + " = " + intToRoman(num));
	}

	public static String intToRoman(int num) {
		// reject number out of range
		if (num < 1 || num > 3999) {
			System.out.println("Number out of range!!! Must be 1 to 3,999");
			return null;
		}

		// arrays for corresponding positions
		/*
		 * whenever you see a zero, it will give an empty string ---------------------
		 * only every four and five positions are changing ---------------------------
		 * (i.e. 4, 5, 9, 10,.., 40, 50, 90, 100, ..., 400, 500, 900, 1000,... etc)
		 */
		String[] units = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
		String[] tens = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "LC" };
		String[] hundreds = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "DM" };
		String[] thousands = { "", "M", "MM", "MMM" };

		int temp = num;
		int remainder = 0;
		int count = 1;
		String roman = "";

		while (temp != 0) {
			// divided by ten take the remainder
			remainder = temp % 10;
			// this remainder is the unit
			if (count == 1) {
				roman = roman + units[remainder];
				// this remainder is the ten
			} else if (count == 2) {
				roman = tens[remainder] + roman;
				// this remainder is the hundred
			} else if (count == 3) {
				roman = hundreds[remainder] + roman;
				// the last one is the thousand
			} else {
				roman = thousands[remainder] + roman;
			}
			// shift position right to left by dividing ten
			temp = temp / 10;
			count++;
		}
		return roman;
	}
}
