package medium;

// 15.11.2020
import java.util.Arrays;

public class ArrayOfMultiples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// dynamic array
		int multiples[];
		multiples = arrayMultiples(15, 17);
		System.out.println(Arrays.toString(multiples));
	}

	public static int[] arrayMultiples(int firstNum, int length) {
		int[] myArray = new int[length];
		int multiplier = 0;

		// assign values to array
		for (int i = 0; i < myArray.length; i++) {
			// increase the multiplier
			multiplier++;
			myArray[i] = firstNum * multiplier;
		}
		return myArray;
	}
}
