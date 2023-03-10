package testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.FlightsPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.HotelsPageObjects;
import utils.Utility;

public class HotelsFunctionalityTest {
	
	WebDriver driver;
	HomePageObjects homePageObject;
	HotelsPageObjects hotelsPageObjects;
	
	@Parameters({"myUrl" , "myBrowser"})
	@BeforeTest
	void startApplication(String url, String browser) {
		driver = Utility.luanchBrowser(url, browser);
		homePageObject = new HomePageObjects(driver);
		hotelsPageObjects = new HotelsPageObjects(driver);
	}
	
	@Test
	void verifyDifferentHotelsBookingOption() {
		Boolean hotelsFlag = homePageObject.isHotelsOptionPresent();
		Assert.assertTrue(hotelsFlag, "Hotels Link is diaplaying on home page");
		homePageObject.clickOnHotels();
		boolean upTo5RoomsFlag = hotelsPageObjects.isUpTo5RoomsCheckboxPresent();
		Assert.assertTrue(upTo5RoomsFlag, "Upto 5 rooms booking option is displaying on Hotels Page");
		boolean groupDealsFlag = hotelsPageObjects.isGroupDealsCheckboxPresent();
		Assert.assertTrue(groupDealsFlag, "Group Deals booking option is displaying on Hotels Page");
	}

	@AfterTest
	void quiteBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
