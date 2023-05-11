package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.obsqura.pages.CategorySelectionPage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ManageNewsPage;
import Retry.Retry;
import Utilities.ExcelUtility;


public class ManageNewsTest extends Base {
	LoginPage loginpage;
	CategorySelectionPage categoryselectionpage;
	ManageNewsPage managenewspage;

	@Test(retryAnalyzer = Retry.class)
	public void VerifyWhetherTheUserCanabletoViewAlertMessageAfterSusccesfullAddingofNewstoManageNewsPagewhileClickOnSaveButton() {
		loginpage = new LoginPage(driver);
		loginpage.enterLoginUname(ExcelUtility.getString(1, 0, "Login"));
		loginpage.enterLoginPassword(ExcelUtility.getString(1, 1, "Login"));
		loginpage.clickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage.clickSelectCategory(ExcelUtility.getString(9, 0, "Categories"));
		managenewspage = new ManageNewsPage(driver);
		managenewspage.clickManageNewsPageCategory().clickNewButtonElement().enterTextarea().clickSaveButtonElement();
		assertTrue(managenewspage.isCheckAlertisDisplayedinManageNewspage(), "News is not created succesfully");

	}

}
