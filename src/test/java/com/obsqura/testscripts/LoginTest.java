package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.obsqura.pages.LoginPage;

import Utilities.ExcelUtility;

public class LoginTest extends Base {
	LoginPage loginpage;

	@Test(dataProvider = "LoginProvider", retryAnalyzer = Retry.class)

	public void loginwithValidusernameandValidPassword(String username, String password) throws IOException {
		loginpage = new LoginPage(driver);
		assertTrue((loginpage.loginUname() == true), "Username Text field is not displayed");
		loginpage.loginUnameEnterText(username);
		assertTrue((loginpage.loginPass() == true), "Password Text field is not displayed");
		loginpage.loginPassenterText(password);
		assertEquals(password.equals("admin"), username.equals("admin"), "Wrong username and password");
		assertTrue(loginpage.Loginbtn() == true, "Sign in button is not displayed");
		loginpage.toClickLoginbtn();
		assertTrue(loginpage.uniqueElement() == true, "Login unsuccesful");
	}

	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() throws IOException {
		return new Object[][] { { "admin", "admin" },

		};

	}

	/*@Test(dataProvider = "LoginProvider1")
	public void loginwithInValidusernameandvalidPassword(String username, String password) throws IOException {
		loginpage = new LoginPage(driver);
		assertTrue((loginpage.loginUname() == true), "Username Text field is not displayed");
		loginpage.loginUnameEnterText(username);
		assertTrue((loginpage.loginPass() == true), "Password Text field is not displayed");
		loginpage.loginPassenterText(password);
		assertEquals(password.equals("admin"), username.equals("admin"), "Wrong username and password");
		assertTrue(loginpage.Loginbtn() == true, "Sign in button is not displayed");
		loginpage.toClickLoginbtn();
		assertTrue(loginpage.uniqueElement() == true, "Login unsuccesful");
	}

	@DataProvider(name = "LoginProvider1")
	public Object[][] getDataFromTestData1() throws IOException {
		return new Object[][] { { "admin123", "admin" },

		};

	}

	@Test(dataProvider = "LoginProvider2")
	public void loginwithValidusernameandInValidPassword(String username, String password) throws IOException {
		loginpage = new LoginPage(driver);
		assertTrue((loginpage.loginUname() == true), "Username Text field is not displayed");
		loginpage.loginUnameEnterText(username);
		assertTrue((loginpage.loginPass() == true), "Password Text field is not displayed");
		loginpage.loginPassenterText(password);
		assertEquals(password.equals("admin"), username.equals("admin"), "Wrong username and password");
		assertTrue(loginpage.Loginbtn() == true, "Sign in button is not displayed");
		loginpage.toClickLoginbtn();
		assertTrue(loginpage.uniqueElement() == true, "Login unsuccesful");
	}

	@DataProvider(name = "LoginProvider2")
	public Object[][] getDataFromTestData2() throws IOException {
		return new Object[][] { { "admin", "admin123" },

		};

	}

	@Test(dataProvider = "LoginProvider3")
	public void loginwithInValidusernameandInValidPassword(String username, String password) throws IOException {
		loginpage = new LoginPage(driver);
		assertTrue((loginpage.loginUname() == true), "Username Text field is not displayed");
		loginpage.loginUnameEnterText(username);
		assertTrue((loginpage.loginPass() == true), "Password Text field is not displayed");
		loginpage.loginPassenterText(password);
		assertEquals(password.equals("admin"), username.equals("admin"), "Wrong username and password");
		assertTrue(loginpage.Loginbtn() == true, "Sign in button is not displayed");
		loginpage.toClickLoginbtn();
		assertTrue(loginpage.uniqueElement() == true, "Login unsuccesful");
	}

	@DataProvider(name = "LoginProvider3")
	public Object[][] getDataFromTestData3() throws IOException {
		return new Object[][] { { "admin111", "admin123" },

		};

	}*/

}
