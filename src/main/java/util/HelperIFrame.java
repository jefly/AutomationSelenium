package util;

import org.openqa.selenium.WebDriver;

public class HelperIFrame {

	public static void switchToIframe(WebDriver driver, String iframeId) {
		driver.switchTo().frame(iframeId);
	}
	
	public static void exitIFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
}
