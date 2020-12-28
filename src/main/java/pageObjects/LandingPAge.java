package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class LandingPAge extends base {

	public WebDriver driver;
	By title = By.xpath("//*[@id='content']/div/div");
	By navgaterBar = By.xpath("//*[contains(@class,'nav navbar-nav navbar-right')]");
	By singIn = By.xpath("//*[contains(@href,'sign_in')]/span[contains(text(),'Login')]");

	public LandingPAge(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getLogin() {
		driver.findElement(singIn).click();
		LoginPage login = new LoginPage(driver);
		return login;
	}

	public WebElement getTitle() {
		return this.driver.findElement(title);
	}

	public WebElement getNavigatorBar() {
		return this.driver.findElement(navgaterBar);
	}




}
