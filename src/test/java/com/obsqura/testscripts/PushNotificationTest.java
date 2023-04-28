package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.CategorySelectionPage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.PushNotificationPage;

import Utilities.ExcelUtility;
import Utilities.TestDataUtility;

public class PushNotificationTest extends Base {
	LoginPage loginpage;
	CategorySelectionPage categoryselectionpage;
	PushNotificationPage pushnotificationpage;

	@Test(retryAnalyzer = Retry.class)
	public void tosendPushnotification() throws IOException {
		loginpage = new LoginPage(driver);
		loginpage.loginUnameEnterText(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Login"));
		loginpage.loginPassenterText(ExcelUtility.getString(1, 1, TestDataUtility.getProperty(), "Login"));
		loginpage.toClickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage
				.toClickSelectCategory(ExcelUtility.getString(12, 0, TestDataUtility.getProperty(), "Categories"));
		pushnotificationpage = new PushNotificationPage(driver);
		pushnotificationpage.toEnterTitle().toEnterDecsription().toClickSendbutton();
		assertTrue(pushnotificationpage.toCheckAlert() == true,
				"Alert information Message send succesfully is not displayed");
	}

	@Test(retryAnalyzer = Retry.class)
	public void Verify_resetButtonFunctionality() throws IOException {
		String expectedTitle = "";
		String expectedDescription = "";
		loginpage = new LoginPage(driver);
		loginpage.loginUnameEnterText(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Login"));
		loginpage.loginPassenterText(ExcelUtility.getString(1, 1, TestDataUtility.getProperty(), "Login"));
		loginpage.toClickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage
				.toClickSelectCategory(ExcelUtility.getString(12, 0, TestDataUtility.getProperty(), "Categories"));
		pushnotificationpage = new PushNotificationPage(driver);
		pushnotificationpage.toEnterTitle().toEnterDecsription().toClickSendbutton();
		String actualTitle = pushnotificationpage.toCheckResetof_Title();
		assertEquals(actualTitle, expectedTitle, "Reset is not working for title element");
		String actualDescription = pushnotificationpage.toCheckResetof_Decsription();
		assertEquals(actualDescription, expectedDescription, "Reset is not working for description element");

	}

}
