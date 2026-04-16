package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * @author Kliona Kennet
 */
public class LoginFormTest 
{

	@Test
	public void testStudentIdentity() {
		String studentId = "224954623";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Kliona Kennet";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
    public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login(null, null);
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	/*
	 * Write more test functions below.
	 */
	
	@Test
	public void testFailEmptyUsernameAndWrongPassword() {
		LoginStatus status = LoginForm.login(null, "xyz");
		Assert.assertTrue(status.isLoginSuccess() == false);
	}

	@Test
	public void testFailEmptyUsernameAndCorrectPassword() {
		LoginStatus status = LoginForm.login(null, "ahsan_pass");
		Assert.assertTrue(status.isLoginSuccess() == false);
	}

	@Test
	public void testFailWrongUsernameAndEmptyPassword() {
		LoginStatus status = LoginForm.login("abc", null);
		Assert.assertTrue(status.isLoginSuccess() == false);
	}

	@Test
	public void testFailWrongUsernameAndWrongPassword() {
		LoginStatus status = LoginForm.login("abc", "xyz");
		Assert.assertTrue(status.isLoginSuccess() == false);
	}

	@Test
	public void testFailWrongUsernameAndCorrectPassword() {
		LoginStatus status = LoginForm.login("abc", "ahsan_pass");
		Assert.assertTrue(status.isLoginSuccess() == false);
	}

	@Test
	public void testFailCorrectUsernameAndEmptyPassword() {
		LoginStatus status = LoginForm.login("ahsan", null);
		Assert.assertTrue(status.isLoginSuccess() == false);
	}

	@Test
	public void testFailCorrectUsernameAndWrongPassword() {
		LoginStatus status = LoginForm.login("ahsan", "xyz");
		Assert.assertTrue(status.isLoginSuccess() == false);
	}

	@Test
	public void testCorrectUsernameAndCorrectPasswordEmptyCode() {
		LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
		Assert.assertTrue(status.isLoginSuccess() == true);
		Assert.assertFalse(LoginForm.validateCode(null));
	}

	@Test
	public void testCorrectUsernameAndCorrectPasswordWrongCode() {
		LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
		Assert.assertTrue(status.isLoginSuccess() == true);
		Assert.assertFalse(LoginForm.validateCode("000000"));
	}

	@Test
	public void testCorrectUsernameAndCorrectPasswordCorrectCode() {
		LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
		Assert.assertTrue(status.isLoginSuccess() == true);
		Assert.assertTrue(LoginForm.validateCode("123456"));
	}
}