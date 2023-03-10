package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePageObjects {
	
	@FindBy (xpath = "//img[@alt = 'Make My Trip']") 
	private WebElement logo;
	
	@FindBy (xpath = "//span[text()='Flights']//parent::a")
	private WebElement flights;
	
	@FindBy (xpath = "//span[text()='Hotels']//parent::a")
	private WebElement hotels;
	
	@FindBy (xpath = "//a[text()='Search']")
	private WebElement searchBtn;
	
	public HomePageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isLogoPresent() {
		return logo.isDisplayed();
	}
	
	public void clickOnLogo() {
		logo.click();
	}
	
	public boolean isFlightsOptionPresent() {
		return flights.isDisplayed();
	}

	public void clickOnFlights() {
		flights.click();
	}
	
	public boolean isHotelsOptionPresent() {
		return hotels.isDisplayed();
	}
	
	public void clickOnHotels() {
		hotels.click();
	}
	
	public void clickSearchButton() {
		if(searchBtn.isDisplayed()) {
			searchBtn.click();
		}
		else {
			Assert.fail("Search Button is not present");
		}
	}
}
