package com.basepackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	public BasePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//ul[@class='top-menu']/li/a[contains(text(),'Books')]")
	private WebElement booksLink;
	
	@FindBy(xpath="//ul[@class='top-menu']/li/a[contains(text(),'Computers')]")
	private WebElement computersLink;
	
	@FindBy(xpath="//ul[@class='top-menu']/li/a[contains(text(),'Electronics')]")
	private WebElement electronicsLink;
	
	@FindBy(xpath="//ul[@class='top-menu']/li/a[contains(text(),'Apparel')]")
	private WebElement apparelShoesLink;
	
	@FindBy(xpath="//ul[@class='top-menu']/li/a[contains(text(),'Digital')]")
	private WebElement digitalDownloadsLink;
	
	@FindBy(xpath = "//ul[@class='top-menu']/li/a[contains(text(),'Jewelry')]")
	private WebElement jewelryLink;
	
	@FindBy(xpath = "//ul[@class='top-menu']/li/a[contains(text(),'Cards')]")
	private WebElement giftCards;

	public WebElement getBooksLink() {
		return booksLink;
	}

	public WebElement getComputersLink() {
		return computersLink;
	}

	public WebElement getElectronicsLink() {
		return electronicsLink;
	}

	public WebElement getApparelShoesLink() {
		return apparelShoesLink;
	}

	public WebElement getDigitalDownloadsLink() {
		return digitalDownloadsLink;
	}

	public WebElement getJewelryLink() {
		return jewelryLink;
	}

	public WebElement getGiftCards() {
		return giftCards;
	}
	
	@FindBy(linkText = "Register")
	private WebElement registerLink;
	
	@FindBy(linkText = "Login")
	private WebElement loginLink;
	
	@FindBy(linkText = "Shopping cart")
	private WebElement shoppingCartLink;
	
	@FindBy(linkText = "WishList")
	private WebElement wishlistLink;
	
	@FindBy(name="q")
	private WebElement searchTextField;

	public WebElement getRegisterLink() {
		return registerLink;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getShoppingCartLink() {
		return shoppingCartLink;
	}

	public WebElement getWishlistLink() {
		return wishlistLink;
	}

	public WebElement getSearchTextField() {
		return searchTextField;
	}
	
	@FindBy(linkText = "Log in")
	private WebElement loginlink;

	public WebElement getLoginlink() {
		return loginlink;
	}
	
	@FindBy(linkText = "Log out")
	private WebElement logoutLink;

	public WebElement getLogoutLink() {
		return logoutLink;
	}
}
