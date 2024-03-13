

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.basepackage.BaseClass;
import com.elementRepository.HomePage;
import com.elementRepository.LoginPage;
import com.elementRepository.WelcomePage;


public class SubscribeToNewsLetterTest extends BaseClass{
	@Test
	public void subscribe() {
		String loginPageLink = "https://demowebshop.tricentis.com/login";
		String userName = "komalgupta121@gmail.com";
		String password = "Shakuni123.@";
		String newsLetterEmail = "udaykapsae@gmail.com";
		String message="Thank you for signing up!";
		
		HomePage home = new HomePage(driver);
		boolean actualResult = home.getUserName().isDisplayed();
		softAssert.assertEquals(actualResult, true, "Login failed");
		Reporter.log("Login successful", true);

		// entering email into newsletter text field
		home.getNewsLetterEmailTextField().sendKeys(newsLetterEmail);
		String actualNewsLetterEmail=home.getNewsLetterEmailTextField().getAttribute("value");
		softAssert.assertEquals(actualNewsLetterEmail, newsLetterEmail,"Data mismatch");
		Reporter.log("User entered correct email into email text field",true);
		home.getNewsLetterSubscribeButton().click();
		actualResult=home.getNewsLetterMessage().isDisplayed();
		softAssert.assertEquals(actualResult, true,"Not subscribed to newsletter");
		Reporter.log("Subscribed to newsletter",true);
	}
}
