package InarAcademy.E2Eproject;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.AssertJUnit;
import java.io.IOException;



import pageObjects.LandingPAge;
import resources.base;

public class TestTitle extends base {

	public static Logger log =LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void Initialize() {
		log.info("Driver is initialized ");
		
	}
	@Test
	public void basePageNavigation() throws IOException {
		driver = initializeDriver();
		driver.get(URL);
		log.info("Navigated to Home page ");
		LandingPAge l = new LandingPAge(driver);
		System.out.println("Title : " + l.getTitle().getText());
		AssertJUnit.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		log.info("succesfully Validated Text m essage");

	}

	@AfterTest
	public void closePages() {
		driver.close();
	}
}
