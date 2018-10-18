package info.sjd.pass;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.Test;

public class PassTest {

	@Test
	public void testSaveReadFile() {
		String password = "passW20!";
		char[] password_chars = password.toCharArray();
		String file_name = "SJD-TASK10-Test.txt";
		
		
		ByteArrayInputStream in = new ByteArrayInputStream(password.getBytes());
		System.setIn(in);
		//Give PASSWORD as user's input in separate stream
		Pass.saveUserPassToFile(file_name); 
		System.setIn(System.in);
		
		
		/* Additionally
		 * ReadFile and check if it is in ROT-13
		 * */
		
		
		char[] password_readed = Pass.readUserPassFromFile(file_name);
		
		assertNotNull(password_readed);
		assertArrayEquals(password_chars, password_readed);
		
		
	}

}
