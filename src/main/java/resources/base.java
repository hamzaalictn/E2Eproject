package resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {

	public WebDriver driver;
	public Properties prop;
	public String URL;

	public WebDriver initializeDriver() throws IOException {
		// chrome || firefox || EI
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"/Users/hamzaalicetin/Desktop/java/E2Eproject/src/main/java/resources/data.properties");

		prop.load(fis);

		String browserName = prop.getProperty("browser");
		if (driver == null) {
			if (browserName.equals("chrome")) {
				// execute in chrome
				System.setProperty("webdriver.chrome.driver", "/Users/hamzaalicetin/Downloads/chromedriver");
				driver = new ChromeDriver();
				URL = prop.getProperty("url");
			} else if (browserName.equals("firefox")) {
				// execute in firefox
				System.setProperty("webdriver.chrome.driver", "/Users/hamzaalicetin/Downloads/chromedriver");
				driver = new FirefoxDriver();
			} else {
				// execute in IE
				System.setProperty("webdriver.chrome.driver", "/Users/hamzaalicetin/Downloads/chromedriver");
				driver = new InternetExplorerDriver();
			}

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		return driver;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getScreenShotPath(String testCaseName, WebDriver driver2) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(testCaseName));
		return destinationFile;

	}
}
