 package InarAcademy.E2Eproject;

import org.testng.annotations.Test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import pageObjects.LandingPAge;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	public static Logger log =LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	
	@BeforeTest
	public void Initialize() {
		log.info("Driver is initialized ");
		
	}
	
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String name, String password) throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page ");
		LandingPAge l = new LandingPAge(driver);
		l.getLogin().click();
		LoginPage login = new LoginPage(driver);
		login.loginEmail(name, password);
		log.info("succesfully Validated");

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		data[0][0] = "nonrestiricUser@gmail.com";
		data[0][1] = "12313";
		data[1][0] = "restiricUser@gmail.com";
		data[1][1] = "12345";
		return data;
	}

	@AfterTest
	public void closePages() {
		driver.close();
	}

}
