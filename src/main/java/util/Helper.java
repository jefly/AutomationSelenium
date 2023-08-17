package util;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class Helper {

	public static void implicitWait(WebDriver driver, long seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	
	public static void switchToIframe(WebDriver driver, String iframeId) {
		driver.switchTo().frame(iframeId);
	}
	
	public static void exitIFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
}
