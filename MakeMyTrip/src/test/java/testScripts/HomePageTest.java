package testScripts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.HomePageObjects;
import utils.Utility;

public class HomePageTest {
	
WebDriver driver;
HomePageObjects hpo;
	
	@Parameters({"myUrl" , "myBrowser"})
	@BeforeTest
	public void startApplication(String url, String browser) {
		driver = Utility.luanchBrowser(url, browser);
	}
	
	@BeforeClass
	void initializeObjects() {
		hpo = new HomePageObjects(driver);
	}
	
	@Test(priority=2)
	void logoTest() {
		boolean logoFlag = hpo.isLogoPresent();
		Assert.assertTrue(logoFlag, "Logo verified");
	}
	
	@Parameters("myUrl")
	@Test(priority=1)
	void urlTest(String expectedUrl) {
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "URL test successful");
	}
	
	@Test(priority=3)
	void verifyFlightsOption() {
		boolean flightsFlag = hpo.isFlightsOptionPresent();
		Assert.assertTrue(flightsFlag, "Flights Option Displying");
		hpo.clickOnFlights();
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, "https://www.makemytrip.com/flights/", "Flights Page got opened");
		hpo.clickOnLogo();
	}
	
	@Test(priority=4)
	void verifyHotelsOption() {
		boolean hotelsFlag = hpo.isHotelsOptionPresent();
		Assert.assertTrue(hotelsFlag, "Hotels Option Displaying");
		hpo.clickOnHotels();
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, "https://www.makemytrip.com/hotels/", "Hotels Page got opened");
		hpo.clickOnFlights();
	}
	
	@AfterTest
	void quiteBrowser() {
		driver.quit();
	}

}
