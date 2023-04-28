package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.CategorySelectionPage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ManageNewsPage;

import Utilities.ExcelUtility;
import Utilities.TestDataUtility;

public class ManageNewsTest extends Base {
	LoginPage loginpage;
	CategorySelectionPage categoryselectionpage;
	ManageNewsPage managenewspage;

	@Test(retryAnalyzer = Retry.class)
	public void toAddNewstoManage_NewsPage() throws IOException {
		loginpage = new LoginPage(driver);
		loginpage.loginUnameEnterText(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Login"));
		loginpage.loginPassenterText(ExcelUtility.getString(1, 1, TestDataUtility.getProperty(), "Login"));
		loginpage.toClickLoginbtn();
		categoryselectionpage = new CategorySelectionPage(driver);
		categoryselectionpage
				.toClickSelectCategory(ExcelUtility.getString(9, 0, TestDataUtility.getProperty(), "Categories"));
		managenewspage = new ManageNewsPage(driver);
		managenewspage.toClickManageNewsPageCategory();
		managenewspage.toClickNewButtonElement().toEnterTextarea().toClickSaveButtonElement();
		assertTrue(managenewspage.toCheckAlertinManageNewspage() == true, "News is not created succesfully");
	}

}
