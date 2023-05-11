package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.obsqura.pages.CategorySelectionPage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ManageCategoryCategoryPage;
import Retry.Retry;
import Utilities.ExcelUtility;


public class ManageCategoryCategoryTest extends Base {
	LoginPage loginpage;
	CategorySelectionPage categoryselectionpage;
	ManageCategoryCategoryPage managecategorycategorypage;

	@Test(retryAnalyzer = Retry.class)
	public void VerifyUserCanAbletoVisibleTheAlertMessageAftrerSuccesfullAddingofnewCategoryinCategorypageWhileClickOnSaveButton() {
		loginpage = new LoginPage(driver);
		loginpage.enterLoginUname(ExcelUtility.getString(1, 0, "Login"));
		loginpage.enterLoginPassword(ExcelUtility.getString(1, 1, "Login"));
		loginpage.clickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage.clickSelectCategory(ExcelUtility.getString(15, 0, "Categories"));
		managecategorycategorypage = new ManageCategoryCategoryPage(driver);
		managecategorycategorypage.clickcategoryOptionin_ManageCategory().clickNewButonforaddingNewCategoryin_ManageCategory().enterCategoryforaddingNewCategoryin_ManageCategory().enterGroupforaddingNewCategoryin_ManageCategory().uploadFile().clicktopMenuRadiobuttonElement().clicksideMenuRadiobuttonElement().clickSaveButtonin_ManageCategory();
		assertTrue(managecategorycategorypage.isAlertDisplayed(),"Alert information Message Category created succesfully is not displayed");

	}

	@Test(retryAnalyzer = Retry.class)
	public void verifytheUserCanAbleToseetheManadatoryMessagewhileaddingnewCategorywithoutEnteringTheManadotoryfieldCategoryWhileClcikOnSaveButton() {
		loginpage = new LoginPage(driver);
		loginpage.enterLoginUname(ExcelUtility.getString(1, 0, "Login"));
		loginpage.enterLoginPassword(ExcelUtility.getString(1, 1, "Login"));
		loginpage.clickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage.clickSelectCategory(ExcelUtility.getString(15, 0, "Categories"));
		managecategorycategorypage = new ManageCategoryCategoryPage(driver);
		managecategorycategorypage.clickcategoryOptionin_ManageCategory().clickNewButonforaddingNewCategoryin_ManageCategory()
		.enterGroupforaddingNewCategoryin_ManageCategory().uploadFile().clicktopMenuRadiobuttonElement().clicksideMenuRadiobuttonElement()
		.clickSaveButtonin_ManageCategory();
		String actual = managecategorycategorypage.gettextCategory();
		assertTrue(actual == null, "category field is not blank");
	}

}
