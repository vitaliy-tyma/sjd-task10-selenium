package info.sjd.util;

public class ROT13 {
	/** ROT-13 of input. */
	public static char[] rot13(char[] input) {
		char[] output = new char[input.length];
		int i = 0;
		for (char c : input) {
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
