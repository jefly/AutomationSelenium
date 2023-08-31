package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.HelperSeleniumAction;
import util.HelperWait;

public class LoginPage extends BaseClass<LoginPage> {

	private final By EMAIL = By.id("username");
	private final By PASSWORD = By.id("password");
	private final By SIGNIN = By.id("loginButton");
	
	private final By LOGIN = By.linkText("Log In");
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterCredentials(String email, String password) {
		
		enterEmail(email);
		clickContinue();

		if(waitTillPasswordIsVisible()) {
			enterPassword(password);
		} else {
			enterCredentials(email, password);
		}

		logger.debug("Credentials are entered");
	}
	
	public void clickContinue() {
		HelperSeleniumAction.click(driver, SIGNIN);
	}
	
	private void enterEmail(String email) {
		HelperSeleniumAction.typeOnText(driver, EMAIL, email);
	}
	
	private void enterPassword(String password) {
		HelperSeleniumAction.typeOnText(driver, PASSWORD, password);
	}
	
	public void clickLoginLink() {
		HelperSeleniumAction.click(driver, LOGIN);
//		logger.info("Login button is clicked");
	}
	
	public boolean verifyLogInLink() {
		return driver.findElements(LOGIN).size() > 0;
	}
	
	public boolean verifyLoginUnsuccessful() {
//		logger.info("Verifying the user is on the login page");
		return driver.findElements(SIGNIN).size() == 0;
	}
	
	private boolean waitTillPasswordIsVisible() {
		
		try {
//			WebElement element = driver.findElement(PASSWORD);
			HelperWait.explicitWaitForVisibility(driver, PASSWORD, 5);
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//			wait.until(ExpectedConditions.visibilityOf(element));
			
		} catch(Exception e) {
//			logger.error(e.toString());
			clickContinue();
			waitTillPasswordIsVisible();
		}
		
		return driver.findElements(PASSWORD).size() > 0;
	}
}
