package hard;

/* 19.12.2020
 * 
 * Convert a Roman numeral to an integer
 * Assume only positive integer (1 to 3,999) should be entered */

public class RomanToInteger {

	public static void main(String[] args) {
		String roman = "MMDCLXXIV";
		System.out.println("The value for " + roman + " is " + romanToInt(roman));
	}

	public static int romanToInt(String roman) {
		int result = 0;
		int temp = 1000;

		// check the Roman input string one char by one char
		for (int i = 0; i < roman.length(); i++) {
			switch (roman.charAt(i)) {
			case 'M':
				// checking the previous value
				if (temp < 1000) {
					// DM = 900, we already have D = 500, in front
					// 900 - 500 = 400
					result += 400;
					// record newly inserted position/value
					temp = 1000;
					break;
				}
				// if no position/value is inserted in front
				result += 1000;
				temp = 1000;
				break;
			case 'D':
				if (temp < 500) {
					// CD = 400, we already have C = 100
					// 400 - 100 = 300
					result += 300;
					temp = 500;
					break;
				}
				// if no position/value is inserted in front
				result += 500;
				temp = 500;
				break;

			case 'C':
				if (temp < 100) {
					// LC = 90, we already have L = 50
					// 90 - 50 = 40
					result += 40;
					temp = 100;
					break;
				}
				// if no position/value is inserted in front
				result += 100;
				// record newly inserted position/value
				temp = 100;
				break;

			case 'L':
				if (temp < 50) {
					// XL = 40, we already have X = 10
					// 40 - 10 = 30
					result += 30;
					temp = 50;
					break;
				}
				// if no position/value is inserted in front
				result += 50;
				temp = 50;
				break;

			case 'X':
				if (temp < 10) {
					// XI = 9, we already have I = 1
					// 9 - 1 = 8
					result += 8;
					// record newly inserted position/value
					temp = 10;
					break;
				}
				// if no position/value is inserted in front
				result += 10;
				temp = 10;

				break;

			case 'V':
				if (temp < 5) {
					// IV = 4, we already have I = 1
					// 4 - 1 = 3
					result += 3;
					temp = 5;
					break;
				}
				// if no position/value is inserted in front
				result += 5;
				temp = 5;
				break;

			case 'I':
				result += 1;
				// record newly inserted position/value
				temp = 1;
				break;

			}
		}
		return result;
	}
}