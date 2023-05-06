package com.obsqura.testscripts;


import static org.testng.Assert.assertTrue;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.obsqura.pages.LoginPage;
import Retry.Retry;
import Utilities.ExcelUtility;


public class LoginTest extends Base {
	LoginPage loginpage;

	@Test(dataProvider = "LoginProvider", retryAnalyzer = Retry.class)

	public void verifyTheUserCanAbletoLoginwithValidusernameandValidPasswordWhileClickonSignInButton(String username,String password) {

		loginpage = new LoginPage(driver);
		assertTrue(loginpage.isLoginUnameIsDisplayed(), "Username Text field is not displayed");
		loginpage.enterLoginUname(username);
		assertTrue(loginpage.isLoginPassIsDisplayed(), "Password Text field is not displayed");
		loginpage.enterLoginPassword(password);
		assertTrue(password.equals("admin") && username.equals("admin"), "Wrong username and password");
		assertTrue(loginpage.isLoginbtnisDisplayed(), "Sign in button is not displayed");
		loginpage.clickLoginbtn();
		assertTrue(loginpage.uniqueElement(), "Login unsuccesful");

	}

	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() {
		return new Object[][] { { ExcelUtility.getString(1, 0, "Login"), ExcelUtility.getString(1, 1, "Login") },

		};

	}

	/*
	 * @Test(dataProvider = "LoginProvider1") public void
	 * verifyTheUserCanAbletoLoginwithInValidusernameandValidPasswordWhileClickonSignInButton
	 * (String username, String password) throws IOException { loginpage = new
	 * LoginPage(driver); assertTrue((loginpage.isLoginUnameIsDisplayed()),
	 * "Username Text field is not displayed"); loginpage.enterLoginUname(username);
	 * assertTrue((loginpage.isLoginPassIsDisplayed()),
	 * "Password Text field is not displayed");
	 * loginpage.enterLoginPassWord(password);
	 * assertEquals(password.equals("admin"), username.equals("admin"),
	 * "Wrong username and password"); assertTrue(loginpage.isLoginbtnisDisplayed(),
	 * "Sign in button is not displayed"); loginpage.ClickLoginbtn();
	 * assertTrue(loginpage.uniqueElement() == true, "Login unsuccesful"); }
	 * 
	 * @DataProvider(name = "LoginProvider1") public Object[][]
	 * getDataFromTestData1() throws IOException { return new Object[][] { {
	 * ExcelUtility.getString(2, 0, "Login"), ExcelUtility.getString(2, 1, "Login")
	 * },
	 * 
	 * };
	 * 
	 * }
	 * 
	 * @Test(dataProvider = "LoginProvider2") public void
	 * verifyTheUserCanAbletoLoginwithValidusernameandInValidPasswordWhileClickonSignInButton
	 * (String username, String password) throws IOException { loginpage = new
	 * LoginPage(driver); assertTrue((loginpage.isLoginUnameIsDisplayed()),
	 * "Username Text field is not displayed"); loginpage.enterLoginUname(username);
	 * assertTrue((loginpage.isLoginPassIsDisplayed() == true),
	 * "Password Text field is not displayed");
	 * loginpage.enterLoginPassWord(password);
	 * assertEquals(password.equals("admin"), username.equals("admin"),
	 * "Wrong username and password"); assertTrue(loginpage.isLoginbtnisDisplayed(),
	 * "Sign in button is not displayed"); loginpage.ClickLoginbtn();
	 * assertTrue(loginpage.uniqueElement(), "Login unsuccesful"); }
	 * 
	 * @DataProvider(name = "LoginProvider2") public Object[][]
	 * getDataFromTestData2() throws IOException { return new Object[][] { {
	 * ExcelUtility.getString(3, 0, "Login"), ExcelUtility.getString(3, 1, "Login")
	 * },
	 * 
	 * };
	 * 
	 * }
	 * 
	 * @Test(dataProvider = "LoginProvider3") public void
	 * verifyTheUserCanAbletoLoginwithInValidusernameandInValidPasswordWhileClickonSignInButton
	 * (String username, String password) throws IOException { loginpage = new
	 * LoginPage(driver); assertTrue((loginpage.isLoginUnameIsDisplayed()),
	 * "Username Text field is not displayed"); loginpage.enterLoginUname(username);
	 * assertTrue((loginpage.isLoginPassIsDisplayed()),
	 * "Password Text field is not displayed");
	 * loginpage.enterLoginPassWord(password);
	 * assertEquals(password.equals("admin"), username.equals("admin"),
	 * "Wrong username and password"); assertTrue(loginpage.isLoginbtnisDisplayed(),
	 * "Sign in button is not displayed"); loginpage.ClickLoginbtn();
	 * assertTrue(loginpage.uniqueElement(), "Login unsuccesful"); }
	 * 
	 * @DataProvider(name = "LoginProvider3") public Object[][]
	 * getDataFromTestData3() throws IOException { return new Object[][] { {
	 * ExcelUtility.getString(4, 0, "Login"), ExcelUtility.getString(4, 1, "Login")
	 * },
	 * 
	 * };
	 * 
	 * }
	 */

}
