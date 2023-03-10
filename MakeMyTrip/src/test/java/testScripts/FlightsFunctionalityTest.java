package testScripts;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.FlightsPageObjects;
import pageObjects.HomePageObjects;
import utils.Utility;

public class FlightsFunctionalityTest {
	
	WebDriver driver;
	HomePageObjects homePageObject;
	FlightsPageObjects flightsPageObjects;
	
	@Parameters({"myUrl" , "myBrowser"})
	@BeforeTest
	void startApplication(String url, String browser) {
		driver = Utility.luanchBrowser(url, browser);
		homePageObject = new HomePageObjects(driver);
		flightsPageObjects = new FlightsPageObjects(driver);
	}
	
	@Test(priority=1)
	void verifyDifferentTripOptions() {
		boolean flightsFlag = homePageObject.isFlightsOptionPresent();
		Assert.assertTrue(flightsFlag, "Flights Option Displying");
		homePageObject.clickOnFlights();
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, "https://www.makemytrip.com/flights/", "Flights Page got opened");
		boolean oneWayTripFlag = flightsPageObjects.isOneWayTripCheckboxPresent();
		Assert.assertTrue(oneWayTripFlag, "One way trip checkbox dispalying");
		boolean roundTripFlag = flightsPageObjects.isRoundTripCheckboxPresent();
		Assert.assertTrue(roundTripFlag, "Round Trip Option displaying");
		boolean multicityTripFlag = flightsPageObjects.isMulitiCityTripCheckboxPresent();
		Assert.assertTrue(multicityTripFlag, "Multi City Trip Option displaying");
	}
	
	@Test(priority=2)
	void verifyDefaultTripSelection() {
		String actualAttribute = flightsPageObjects.grabAttributeOfWayTrip("class");
		Assert.assertEquals(actualAttribute, "selected", "By Default OneWayTrip Option is checked");
	}
	
	@Test(priority=3)
	void serachFlights() throws InterruptedException {
		flightsPageObjects.enterFromCityField("Pune");
		flightsPageObjects.enterDestinationCityField("Delhi");
		flightsPageObjects.selectNextDay();
		homePageObject.clickSearchButton();
	}
	
	@AfterTest
	void quiteBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
