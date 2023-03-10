package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelsPageObjects {
	
	@FindBy (xpath  = "//span[text()= 'UPTO 5 ROOMS']//parent::li")
	private WebElement upTo5RoomsCheckbox;
	
	@FindBy (xpath  = "//span[text()= 'GROUP DEALS']//parent::li")
	private WebElement groupDealsCheckbox;
	
	public HotelsPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isUpTo5RoomsCheckboxPresent() {
		return upTo5RoomsCheckbox.isDisplayed();
	}
	
	public boolean isGroupDealsCheckboxPresent() {
		return groupDealsCheckbox.isDisplayed();
	}

}
