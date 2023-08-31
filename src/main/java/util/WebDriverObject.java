package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class WebDriverObject {

	private static WebDriver driver;
	
	private WebDriverObject() {}
	
	public static WebDriver getInstance() {
		
		if(driver == null) {
			synchronized (WebDriverObject.class) {
				if(driver == null) {
					WebDriverManager.chromedriver().setup();
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--disable-notifications");
					driver = new ChromeDriver(options);
				}
			}
		}
		
		return driver;
	}	
	
	public static void closeDriver() {
		
		if(driver != null) {
			driver.close();
			driver = null;
		}
	}
}
