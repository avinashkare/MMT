package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Utility {
	
	static WebDriver driver;
	
	public static WebDriver luanchBrowser(String url, String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Akash Kare\\OneDrive\\Documents\\Automation\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equals("edge")) {
			System.setProperty("webdriver.edge.driver", 
				"C:\\Users\\Akash Kare\\OneDrive\\Documents\\Automation\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		return driver;
	}

}
