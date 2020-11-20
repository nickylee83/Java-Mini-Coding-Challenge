package medium;

// 16.11.2020
public class PrintBinaryRecursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printBinRec(23);
	}

	public static void printBinRec(int num) {
		if (num > 0) {
			// divide number by 2
			printBinRec(num / 2);
			// print the remainder from the stack
			System.out.printf("%d", num % 2);
		}
	}
}
