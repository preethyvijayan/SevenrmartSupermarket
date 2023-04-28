package com.obsqura.testscripts;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsqura.pages.LoginPage;
import com.obsqura.pages.VerifyLogonamePage;

import Utilities.ExcelUtility;
import Utilities.TestDataUtility;

public class VerifyLogonameTest extends Base {
	LoginPage loginpage;
	VerifyLogonamePage verifylogonamepage;

	@Test(retryAnalyzer = Retry.class)
	@Parameters({ "logoname" })
	public void verifyLogo(String logoname) throws IOException {
		loginpage = new LoginPage(driver);
		loginpage.loginUnameEnterText(ExcelUtility.getString(1, 0, TestDataUtility.getProperty(), "Login"));
		loginpage.loginPassenterText(ExcelUtility.getString(1, 1, TestDataUtility.getProperty(), "Login"));
		loginpage.toClickLoginbtn();
		verifylogonamepage = new VerifyLogonamePage(driver);
		verifylogonamepage.getTextLogoname();

	}
}
