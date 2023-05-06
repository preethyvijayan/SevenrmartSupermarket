package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.obsqura.pages.CategorySelectionPage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.PushNotificationPage;
import Retry.Retry;
import Utilities.ExcelUtility;


public class PushNotificationTest extends Base {
	LoginPage loginpage;
	CategorySelectionPage categoryselectionpage;
	PushNotificationPage pushnotificationpage;

	@Test(retryAnalyzer = Retry.class)
	public void verifyUserCanAbleToSeetheSuccesfullAlertMessageAfterSendingThePushNotificationBySendButton() {
		loginpage = new LoginPage(driver);
		loginpage.enterLoginUname(ExcelUtility.getString(1, 0, "Login"));
		loginpage.enterLoginPassword(ExcelUtility.getString(1, 1, "Login"));
		loginpage.clickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage.clickSelectCategory(ExcelUtility.getString(12, 0, "Categories"));
		pushnotificationpage = new PushNotificationPage(driver);
		pushnotificationpage.toEnterTitle().toEnterDecsription().toClickSendbutton();
		assertTrue(pushnotificationpage.toCheckAlert(), "Alert information Message send succesfully is not displayed");

	}

	@Test(retryAnalyzer = Retry.class)
	public void VerifyUserCAnAbletoSeetheDescrptionAndTitleFieldinBlankWhileClickOnResetButton() {

		String expectedTitle = "";
		String expectedDescription = "";
		loginpage = new LoginPage(driver);
		loginpage.enterLoginUname(ExcelUtility.getString(1, 0, "Login"));
		loginpage.enterLoginPassword(ExcelUtility.getString(1, 1, "Login"));
		loginpage.clickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage.clickSelectCategory(ExcelUtility.getString(12, 0, "Categories"));
		pushnotificationpage = new PushNotificationPage(driver);
		pushnotificationpage.toEnterTitle().toEnterDecsription().toClickSendbutton();
		String actualTitle = pushnotificationpage.toCheckResetof_Title();
		assertEquals(actualTitle, expectedTitle, "Reset is not working for title element");
		String actualDescription = pushnotificationpage.toCheckResetof_Decsription();
		assertEquals(actualDescription, expectedDescription, "Reset is not working for description element");

	}

}
