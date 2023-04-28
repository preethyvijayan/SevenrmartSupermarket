package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.obsqura.pages.CategorySelectionPage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ManageFooterTextPage;

import Utilities.ExcelUtility;
import Utilities.TestDataUtility;

public class ManageFooterTextTest extends Base {
	LoginPage loginpage;
	CategorySelectionPage categoryselectionpage;
	ManageFooterTextPage managefootertextpage;

	@Test(retryAnalyzer = Retry.class)
	public void update_FooterText() throws IOException {
		loginpage = new LoginPage(driver);
		loginpage.loginUnameEnterText(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Login"));
		loginpage.loginPassenterText(ExcelUtility.getString(1, 1, TestDataUtility.getProperty(), "Login"));
		loginpage.toClickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage
				.toClickSelectCategory(ExcelUtility.getString(9, 0, TestDataUtility.getProperty(), "Categories"));
		managefootertextpage = new ManageFooterTextPage(driver);
		managefootertextpage.toselectSubcategoryManageFooterText().toClickEditButton().toEnterAddress().toEnterEmail();
		String expectedData = managefootertextpage.toGetEmail();
		managefootertextpage.toEnterPhoneNo().toClickUpdateButton();
		assertTrue(managefootertextpage.toDisplayAlertElement() == true,
				"Footer Text Updated succesfully alert is not displayed");
		String actualData = managefootertextpage.getTabledata();
		assertTrue(actualData.contains(expectedData), "Updated data is not in the table");

	}
}
