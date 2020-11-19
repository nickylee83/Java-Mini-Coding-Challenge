package hard;

import java.util.Random;
// Odoo Q2 A little intelligent guess // modified
// 16/11/2020

public class GuessANumAI {

	private static int count;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// generate a random number
		int randomNum = generateRandomNum();
		String result = "";
		int guessNum = 0;
		int counter = 0;
		int max = 1000000;
		int min = 0;
		// show random number
		System.out.println(randomNum);
		// run this as long as I cannot guess it right
		while (randomNum != guessNum) {
			if (guessNum < randomNum) {
				// if my guess is too low, this should be the minimum
				min = guessNum;

				if (guessNum < min) {
					// if my guess is even lower than the minimum, the guess
					// should be the minimum
					min = guessNum;
				}
				// guess the number using my min value (my lowest guess) and max
				// (upperbound)
				guessNum = generateGuessNum(min, max);
			} else if (guessNum > randomNum) {
				// if my guess is too high, this should be the maximum
				max = guessNum;
				if (guessNum > max) {
					// if my guess is even higher than the maximum, the guess
					// should be the maximum
					max = guessNum;
				}
				// guess the number using min (lowerbound) and my max value (my
				// highest guess)
				guessNum = generateGuessNum(min, max);
			}
			// verify the guess (low/high)
			result = verify(randomNum, guessNum);
			System.out.println(result);
			counter++;
			// if more than 50 times, it's game over
			if (counter > 49) {
				System.out.println("You lose! Game over!");
				break;
			}
		}
	}

	// this is just to generate the random number
	public static int generateRandomNum() {
		// randomize a number between 1 to 1,000
		Random rand = new Random();
		int upperbound = 1000000;
		int lowerbound = 1;

		int randomNum = rand.nextInt(upperbound - lowerbound) + lowerbound;
		return randomNum;
	}

	// this is to generate the guess number
	public static int generateGuessNum(int lowerbound, int upperbound) {
		Random rand = new Random();

		int randomNum = rand.nextInt(upperbound - lowerbound) + lowerbound;
		return randomNum;
	}

	// verify whether my guess is right or wrong
	public static String verify(int randomNum, int guessNum) {
		String response = "";
		// too low
		if (guessNum < randomNum) {
			count++;
			response = "Your guess is too low! " + guessNum;
			// too high
		} else if (guessNum > randomNum) {
			count++;
			response = "Your guess is too high! " + guessNum;
			// the guess is right
		} else if (randomNum == guessNum) {
			// right guess
			count++;
			response = "Congratualtions!!!\nYou have the right guess in " + count + " times! " + guessNum;
		}

		return response;
	}
}
