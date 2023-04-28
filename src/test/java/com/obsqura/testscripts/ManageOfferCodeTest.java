package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ManageOfferCodePage;

import Utilities.ExcelUtility;
import Utilities.TestDataUtility;

public class ManageOfferCodeTest extends Base {
	LoginPage loginpage;
	ManageOfferCodePage manageoffercodepage;

	@Test(retryAnalyzer = Retry.class)
	public void toCheckTheFuctionalityofMoreInfoicon() throws IOException {
		loginpage = new LoginPage(driver);
		loginpage.loginUnameEnterText(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Login"));
		loginpage.loginPassenterText(ExcelUtility.getString(1, 1, TestDataUtility.getProperty(), "Login"));
		loginpage.toClickLoginbtn();
		manageoffercodepage = new ManageOfferCodePage(driver);
		manageoffercodepage.toClickMoreinfoForManageofferCode();
		String actual = manageoffercodepage.toCheckUniqueElementToVerifytheNavigatedpage();
		String expected = ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "ManageOfferCode");
		assertEquals(actual, expected, "Manage Gift card and voucher page is not displayed");
	}

	@Test(retryAnalyzer = Retry.class)
	public void toaddOfferCodein_ManageOfferCodePage() throws IOException {
		loginpage = new LoginPage(driver);
		loginpage.loginUnameEnterText(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Login"));
		loginpage.loginPassenterText(ExcelUtility.getString(1, 1, TestDataUtility.getProperty(), "Login"));
		loginpage.toClickLoginbtn();
		manageoffercodepage = new ManageOfferCodePage(driver);
		manageoffercodepage.toClickMoreinfoForManageofferCode().toClickNewButtoninManageOffercodePage();
		manageoffercodepage.toEnterOffercode();
		manageoffercodepage.toSelectRadioButtoninManageOffercodePage().toEnterPercentage().toEnterAmount()
				.toEnterDescription().toUploadFile().toClickSaveButtoninManageOffercodePage();
		assertTrue(manageoffercodepage.toDisplayAlertElement() == true,
				"Alert message Odder Code created succesfully is not displayed");
	}

	@Test(retryAnalyzer = Retry.class)
	@Parameters({ "offercode" })
	public void toSearchOfferCodein_ManageOfferCodePage(String offercode) throws IOException {
		loginpage = new LoginPage(driver);
		loginpage.loginUnameEnterText(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Login"));
		loginpage.loginPassenterText(ExcelUtility.getString(1, 1, TestDataUtility.getProperty(), "Login"));
		loginpage.toClickLoginbtn();
		manageoffercodepage = new ManageOfferCodePage(driver);
		manageoffercodepage.toClickMoreinfoForManageofferCode().toClickSearchButtoninManageOffercodePage();
		manageoffercodepage.toEnterOffercodeForSearch(offercode);
		manageoffercodepage.toClicSearchButtonForSearchinManageOffercodePage();
		String actual = manageoffercodepage.togetResultTabledata();
		String expected = manageoffercodepage.gettextOffercode();
		assertTrue(actual.contains(expected) == true, "The entered category is not in table");

	}

}
