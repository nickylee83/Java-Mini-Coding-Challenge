package hard;
// 18.11.2020

// password validation

import java.util.regex.*;

/* Length between 6 and 24 characters.
 At least one upper case letter (A-Z).
 At least one lower case letter (a-z).
 At least one digit (0-9).
 Maximum of 2 repeated characters.
 Supported special characters:
 ! @ # $ % ^ & * ( ) + = _ { } : ; " ' ? < > , .
 */

public class PasswordValidation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String password = "Aiu7deoo#";

		if (validatePassword(password) == true) {
			System.out.println("Your password is valid and accepted");
		} else {
			System.out.println("Your password is not valid!!!");
		}
	}

	public static boolean validatePassword(String password) {
		int c = 0;

		boolean rule1 = false, rule2 = false, rule3 = false, rule4 = false;
		// rule 0 = length must be between 6 and 24
		if (password.length() > 5 && password.length() < 25) {
			for (int i = 0; i < password.length(); i++) {
				// rule 1 = check A-Z (.take ASCII code for every
				// char.)
				c = (int) password.charAt(i);
				if (c > 64 && c < 91) {
					rule1 = true;
					// rule 2 = check a-z
				} else if (c > 96 && c < 123) {
					rule2 = true;
					// rule 3 = check 0-9
				} else if (c > 47 && c < 58) {
					rule3 = true;
					// rule 4 = check special chars
					// .{0,} means zero or more chars in front of special chars
				} else if (Pattern.matches(".{0,}[! @ # $ % ^ & * ( ) + = _  { } : ; \" \' ? < > , .].{0,}",
						password) == true) {
					rule4 = true;
				}
			}
			// if all the rules are fulfilled, the password is valid
			if (rule1 == true && rule2 == true && rule3 == true && rule4 == true) {
				return true;
			}
		}
		return false;
	}

}
