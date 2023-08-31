package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperSeleniumAction {

	public static void click(WebDriver driver, By element) {
		driver.findElement(element).click();
	}
	
	public static void typeOnText(WebDriver driver, By element, String text) {
		driver.findElement(element).sendKeys(text);
	}
}
