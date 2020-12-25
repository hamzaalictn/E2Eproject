package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import resources.base;

public class LoginPage extends base {

	public WebDriver driver;
	By emailAddress = By.id("user_email");
	By password = By.id("user_password");
	By login = By.xpath("//*[@id=\'hero\']/div/form/div[3]/input");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void loginEmail(String email,String password) {
		driver.findElement(emailAddress).sendKeys(email);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(login).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public By getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(By emailAddress) {
		this.emailAddress = emailAddress;
	}

	public By getPassword() {
		return password;
	}

	public void setPassword(By password) {
		this.password = password;
	}

	public By getLogin() {
		return login;
	}

	public void setLogin(By login) {
		this.login = login;
	}

}
