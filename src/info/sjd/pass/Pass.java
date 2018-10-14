package info.sjd.pass;

import java.util.Arrays;

public class Pass {
	/* Plain text password [to be deleted in production] "passW20!" */
	private static char[] password_char = { 'c', 'n', 'f', 'f', 'J', '7', '5', '!' };

	public static char[] getPassArray() {
		char[] password = new char[password_char.length];
		password = rot13(password_char);
		return password;
	}

	public static char[] rot13(char[] input) {
		char[] output = new char[input.length];
		int i = 0;
		for (char c : password_char) {
			if (c >= 'a' && c <= 'm')
				c += 13;
			else if (c >= 'A' && c <= 'M')
				c += 13;
			else if (c >= 'n' && c <= 'z')
				c -= 13;
			else if (c >= 'N' && c <= 'Z')
				c -= 13;
			else if (c >= '0' && c <= '4')
				c += 5;
			else if (c >= '5' && c <= '9')
				c -= 5;

			output[i] = c;
			i++;
		}
		return output;
	}
}
