package info.sjd.pass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import info.sjd.util.ROT13;

public class Pass {
	private static Logger logger = Logger.getLogger(Pass.class.getName());


	/** To be used one time to save the password. */
	public static boolean saveUserPassToFile(String file_name) {

		Scanner scanner = new Scanner(System.in);
		boolean debug = Boolean.TRUE;
		String input;
		if (!debug) {
			System.out.print("Enter your password: ");
			input = scanner.nextLine();
		} else {
			input = "passW20!";
		}

		char[] pass = input.toCharArray();
		pass = ROT13.rot13(pass);

		File file = new File(file_name);
		try {
			FileWriter writer = new FileWriter(file);
			writer.write(pass);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			logger.log(Level.SEVERE, "FileWriter error: " + e.getMessage());
			return Boolean.FALSE;
		}
		/* Clear sensitive data. */
		Arrays.fill(pass, '\u0000');

		return Boolean.TRUE;
	}

	
	/** To be used one time to save the password. */
	public static char[] readUserPassFromFile(String file_name) {
		StringBuilder input = new StringBuilder();
		try {
			File file = new File(file_name);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			input.append(reader.readLine());
			reader.close();
		} catch (IOException e) {
			logger.log(Level.SEVERE, "FileReader error: " + e.getMessage());
			return null;
		}
		char[] pass = new char[input.length()];
		input.getChars(0, input.length(), pass, 0);
		pass = ROT13.rot13(pass);

		return pass;
	}
}
