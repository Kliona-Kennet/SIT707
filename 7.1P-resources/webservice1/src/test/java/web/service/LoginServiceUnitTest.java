package web.service;

import org.junit.Assert;
import org.junit.Test;

public class LoginServiceUnitTest {

	@Test
	public void testValidLogin() {
		Assert.assertTrue(LoginService.login("kliona", "kliona_pass", "2002-03-04"));
	}

	@Test
	public void testInvalidUsername() {
		Assert.assertFalse(LoginService.login("wronguser", "kliona_pass", "2002-03-04"));
	}

	@Test
	public void testInvalidPassword() {
		Assert.assertFalse(LoginService.login("kliona", "wrongpass", "2002-03-04"));
	}

	@Test
	public void testInvalidDob() {
		Assert.assertFalse(LoginService.login("kliona", "kliona_pass", "2000-01-01"));
	}

	@Test
	public void testEmptyUsername() {
		Assert.assertFalse(LoginService.login("", "kliona_pass", "2002-03-04"));
	}

	@Test
	public void testEmptyPassword() {
		Assert.assertFalse(LoginService.login("kliona", "", "2002-03-04"));
	}

	@Test
	public void testEmptyDob() {
		Assert.assertFalse(LoginService.login("kliona", "kliona_pass", ""));
	}

	@Test
	public void testNullUsername() {
		Assert.assertFalse(LoginService.login(null, "kliona_pass", "2002-03-04"));
	}

	@Test
	public void testNullPassword() {
		Assert.assertFalse(LoginService.login("kliona", null, "2002-03-04"));
	}

	@Test
	public void testNullDob() {
		Assert.assertFalse(LoginService.login("kliona", "kliona_pass", null));
	}
}