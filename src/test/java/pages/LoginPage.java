package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BaseClass<LoginPage> {

	private final By EMAIL = By.id("username");
	private final By PASSWORD = By.id("password");
	private final By LOGIN = By.linkText("Log In");
	private final By SIGNIN = By.id("loginButton");
	
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

		logger.info("Credentials are entered");
	}
	
	public void clickContinue() {
		driver.findElement(SIGNIN).click();
	}
	
	private void enterEmail(String email) {
		driver.findElement(EMAIL).sendKeys(email);
	}
	
	private void enterPassword(String password) {
		driver.findElement(PASSWORD).sendKeys(password);
	}
	
	public void clickLoginLink() {
		driver.findElement(LOGIN).click();
		logger.info("Login button is clicked");
	}
	
	public boolean verifyLogInLink() {
		return driver.findElements(LOGIN).size() > 0;
	}
	
	public boolean verifyLoginUnsuccessful() {
		logger.info("Verifying the user is on the login page");
		return driver.findElements(SIGNIN).size() == 0;
	}
	
	private boolean waitTillPasswordIsVisible() {
		
		try {
			WebElement element = driver.findElement(PASSWORD);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(element));
			
		} catch(Exception e) {
			clickContinue();
			waitTillPasswordIsVisible();
		}
		
		return driver.findElements(PASSWORD).size() > 0;
	}
}
