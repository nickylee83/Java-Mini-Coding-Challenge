package medium;

// 15.11.2020
// add numbers recursively
public class RecursiveSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		int num = 20;
		sum = recursiveSum(num);
		System.out.println("\nAnswer = " + sum);
	}

	public static int recursiveSum(int num) {
		if (num != 0) {
			System.out.print(num + " ");
			return num + recursiveSum(num - 1);
		}
		return 0;
	}

}
