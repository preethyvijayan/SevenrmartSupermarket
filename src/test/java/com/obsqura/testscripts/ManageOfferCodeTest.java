package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ManageOfferCodePage;
import Retry.Retry;
import Utilities.ExcelUtility;


public class ManageOfferCodeTest extends Base {
	LoginPage loginpage;
	ManageOfferCodePage manageoffercodepage;

	@Test(retryAnalyzer = Retry.class)
	public void VerifyTheUserCanAbletoNavigateTheCorrespondingpageManageGiftcardVoucherPageWhileClickOnMoreInfoIcon() {
		loginpage = new LoginPage(driver);
		loginpage.enterLoginUname(ExcelUtility.getString(1, 0, "Login"));
		loginpage.enterLoginPassword(ExcelUtility.getString(1, 1, "Login"));
		loginpage.clickLoginbtn();
		manageoffercodepage = new ManageOfferCodePage(driver);
		manageoffercodepage.clickMoreinfoForManageofferCode();
		String actual = manageoffercodepage.checkUniqueElementToVerifytheNavigatedpage();
		String expected = ExcelUtility.getString(1, 0, "ManageOfferCode");
		assertEquals(actual, expected, "Manage Gift card and voucher page is not displayed");
	}

	@Test(retryAnalyzer = Retry.class)
	public void verifyTheUserCanAbletoviewAlertMessageafterSuccesfullAddingOfNewOfferCodeinManageOfferCodePageWhileClickOnSaveButton() {
		loginpage = new LoginPage(driver);
		loginpage.enterLoginUname(ExcelUtility.getString(1, 0, "Login"));
		loginpage.enterLoginPassword(ExcelUtility.getString(1, 1, "Login"));
		loginpage.clickLoginbtn();
		manageoffercodepage = new ManageOfferCodePage(driver);
		manageoffercodepage.clickMoreinfoForManageofferCode().clickNewButtoninManageOffercodePage();
		manageoffercodepage.enterOffercode();
		manageoffercodepage.selectRadioButtoninManageOffercodePage().enterPercentage().enterAmount().enterDescription()
				.uploadFile().clickSaveButtoninManageOffercodePage();
		assertTrue(manageoffercodepage.isAlertElementisDisplayed(),"Alert message Offer Code created succesfully is not displayed");
	}

	@Test(retryAnalyzer = Retry.class)
	@Parameters({ "offercode" })
	public void ValidateTheSearchOfferCodeIsDispalyingInListOfferCodeTableWhileClickOnSearchButton(String offercode) {
		loginpage = new LoginPage(driver);
		loginpage.enterLoginUname(ExcelUtility.getString(1, 0, "Login"));
		loginpage.enterLoginPassword(ExcelUtility.getString(1, 1, "Login"));
		loginpage.clickLoginbtn();
		manageoffercodepage = new ManageOfferCodePage(driver);
		manageoffercodepage.clickMoreinfoForManageofferCode().clickSearchButtoninManageOffercodePage();
		manageoffercodepage.enterOffercodeForSearch(offercode);
		manageoffercodepage.clicSearchButtonForSearchinManageOffercodePage();
		String actual = manageoffercodepage.getResultTabledata();
		String expected = manageoffercodepage.gettextOffercode();
		assertTrue(actual.contains(expected), "The entered category is not in table");

	}

}
