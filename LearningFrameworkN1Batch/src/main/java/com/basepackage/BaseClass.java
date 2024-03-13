package com.basepackage;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.elementRepository.LoginPage;
import com.utilityClasses.DataUtilityClass;
import com.utilityClasses.FrameworkConstants;


public class BaseClass implements FrameworkConstants {

	public WebDriver driver;
	BasePage basePage;
	LoginPage login;
	public SoftAssert softAssert;
	
	@Parameters("browserName")
	@BeforeClass
	public void launchBrowser(@Optional("chrome") String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			// to launch empty browser--Upcasting
			driver = new ChromeDriver();
			Reporter.log("Browser is launched",true);
		} else if (browserName.equalsIgnoreCase("edge")) {
			// to launch empty browser--Upcasting
			 driver= new EdgeDriver();
		}else if (browserName.equalsIgnoreCase("firefox")) {
			// to launch empty browser--Upcasting
			 driver= new FirefoxDriver();
		}
		// maximize the browser
		driver.manage().window().maximize();
		// adding implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		// launching the web site
		driver.get("https://demowebshop.tricentis.com/");
		softAssert = new SoftAssert();
	}

	@BeforeMethod
	public void login() throws IOException {
		DataUtilityClass data=new DataUtilityClass();
		basePage=new BasePage(driver);
		login=new LoginPage(driver);
		basePage.getLoginlink().click();
		login.getEmailTextField().sendKeys(data.readingDataFromPropertyFile(loginPath, "email"));
		login.getPasswordTextField().sendKeys(data.readingDataFromPropertyFile(loginPath, "password"));
		login.getLoginButton().click();
	}

	@AfterMethod
	public void logout() {
		basePage.getLogoutLink().click();
		softAssert.assertAll();
	}

	@AfterClass
	public void quit() {
		driver.quit();
	}
}
