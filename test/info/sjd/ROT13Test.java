package info.sjd;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import info.sjd.util.ROT13;

public class ROT13Test {

	@Test
	public void testROT13() {
		String pass = "passW20!";
		char[] pass_chars = pass.toCharArray();
		char[] expected_chars = new char[] {'c','n','f','f','J','7','5','!'};
		
		char[] pass_rot13 = ROT13.rot13(pass_chars);

		assertNotNull(pass_rot13);
		assertArrayEquals(expected_chars, pass_rot13);
		
		expected_chars = new char[] {'p','a','s','s','W','2','0','!'};
		assertArrayEquals(expected_chars, ROT13.rot13("cnffJ75!".toCharArray()));
		
	}

}
