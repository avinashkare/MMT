package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FlightsPageObjects {
	WebDriver driver;
	
	@FindBy (xpath = "//li[@data-cy='oneWayTrip']")
	private WebElement oneWayTripCheckbox;
	
	@FindBy (xpath = "//li[@data-cy='roundTrip']")
	private WebElement roundTripCheckbox;
	
	@FindBy (xpath = "//li[@data-cy='mulitiCityTrip']")
	private WebElement mulitiCityTripCheckbox;
	
	@FindBy (id = "fromCity")
	private WebElement fromCity;
	
	@FindBy (id = "toCity")
	private WebElement toCity;
	
	@FindBy (xpath = "//input[@placeholder = 'From']")
	private WebElement fromCityInputField;
	
	@FindBy (xpath = "//input[@placeholder = 'To']")
	private WebElement toCityInputField;
	
	@FindBy (xpath = "//ul[@class='react-autosuggest__suggestions-list']//li")
	private WebElement autoSuggestionCity;
	
	@FindBy (xpath = "//div[@class='DayPicker']//child::div[@aria-selected='true']")
	private WebElement nextDay;
	
	public FlightsPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isOneWayTripCheckboxPresent() {
		return oneWayTripCheckbox.isDisplayed();
	}
	
	public boolean isRoundTripCheckboxPresent() {
		return roundTripCheckbox.isDisplayed();
	}
	
	public boolean isMulitiCityTripCheckboxPresent() {
		return mulitiCityTripCheckbox.isDisplayed();
	}
	
	public String grabAttributeOfWayTrip(String attribute) {
		return oneWayTripCheckbox.getAttribute(attribute);
	}
	
	public void enterFromCityField(String city) throws InterruptedException {
		if(fromCity.isDisplayed()) {
			fromCity.click();
			Thread.sleep(1000);
			fromCityInputField.sendKeys(city);
			Thread.sleep(1000);
			autoSuggestionCity.click();
		}
		else {
			Assert.fail("From City Field is not clickable");
		}
	}
	
	public void enterDestinationCityField(String city) throws InterruptedException {
		if(toCity.isDisplayed()) {
			toCity.click();
			Thread.sleep(1000);
			toCityInputField.sendKeys(city);
			Thread.sleep(1000);
			autoSuggestionCity.click();
		}
		else {
			Assert.fail("To City Field is not clickable");
		}
	}
	
	public void selectNextDay() {
		if(nextDay.isDisplayed()) {
			nextDay.click();
		}
		else {
			System.out.println("Next Day element is not visible");
		}
	}

}
