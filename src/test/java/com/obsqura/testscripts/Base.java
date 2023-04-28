package com.obsqura.testscripts;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Utilities.ScreenShotUtility;
import Utilities.WaitUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public WebDriver driver;
	public Properties prop, prop1;
	FileInputStream fs, fs1;
	public ScreenShotUtility scrshot;
	WaitUtility waitutility = new WaitUtility();

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void initilizeBrowser(String browser) throws Exception {
		prop = new Properties();
		try {
			fs = new FileInputStream(System.getProperty("user.dir") + constants.Constants.CONFIGfILE);

		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			prop.load(fs);
		} catch (Exception e) {
			// TODO: handle exception
		}
		prop1 = new Properties();

		try {
			fs = new FileInputStream(System.getProperty("user.dir") + constants.Constants.TESTDATAFILE);

		} catch (Exception e) {
			// TODO: handle exception
		}
		try {

			prop1.load(fs);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (browser.equalsIgnoreCase("firefox")) {
			driver = WebDriverManager.firefoxdriver().create();

		}

		else if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(chromeOptions);
		}

		else if (browser.equalsIgnoreCase("edge")) {

			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver(edgeOptions);
		} else {
			throw new Exception("Browser is not correct");
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		waitutility.pageLoadTimeout(driver);
	}

	@AfterMethod(alwaysRun = true)
	public void browserQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			scrshot = new ScreenShotUtility();
			scrshot.getScreenShot(driver, iTestResult.getName());
		}

		driver.quit();
	}
}
