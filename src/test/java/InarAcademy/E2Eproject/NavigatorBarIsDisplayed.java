package InarAcademy.E2Eproject;

import org.testng.annotations.AfterTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import pageObjects.LandingPAge;
import resources.base;

public class NavigatorBarIsDisplayed extends base {

	@Test
	public void basePageNavigation() throws IOException {
		driver = initializeDriver();
		driver.get(URL);
		LandingPAge l = new LandingPAge(driver);
		AssertJUnit.assertTrue(l.getNavigatorBar().isDisplayed());

		setURL("https://www.udemy.com/");
		driver.get(URL);

	}

	@AfterTest
	public void closePages() {
		driver.close();
	}
}
