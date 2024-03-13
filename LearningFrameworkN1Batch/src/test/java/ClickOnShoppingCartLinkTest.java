

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

public class ClickOnShoppingCartLinkTest extends BaseClass{
	@Test
	public void clickOnShoppingCartLink() {
		String loginPageLink = "https://demowebshop.tricentis.com/login";
		String userName = "komalgupta121@gmail.com";
		String password = "Shakuni123.@";
		String shoppingCartLink="https://demowebshop.tricentis.com/cart";
		
		HomePage home = new HomePage(driver);
		boolean actualResult = home.getUserName().isDisplayed();
		softAssert.assertEquals(actualResult, true, "Login failed");
		Reporter.log("Login successful", true);
		
		//click on shopping cart link
		home.getShoppingCartLink().click();
		softAssert.assertEquals(driver.getCurrentUrl(), shoppingCartLink,"Shopping cart page is not opened");
		Reporter.log("Shopping cart page is opened",true);
	}
}
