package stepdefinitions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import config.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import util.Helper;
import util.WebDriverObject;

public class LoginStep {
	
	private WebDriver driver = null;
	private LoginPage login = null;
	
	@Before()
	public void init() {
		driver = WebDriverObject.getInstance();
		login = new LoginPage(driver);
	}
	
	@Given("user is on login page")
	public void onLoginPage() {
		driver.get(ConfigReader.getUrl());
		driver.manage().window().maximize();
	}
	
	@And("clicks on the Log In link")
	public void goToLoginPage() {
		login.clickLoginLink();
	}
	
	@When("user enters correct email and incorrect password {string} on the login page")
	public void enterCredentials(String password) {
		login.enterCredentials(ConfigReader.getEmail(), password);
	}
	
	@And("click the sign in button")
	public void clickSignIn() {
		login.clickContinue();
	}
	
	@Then("user should not be allowed to login")
	public void verifyTheLoginPage() {
		boolean loginStatus = login.verifyLoginUnsuccessful();
		assertFalse(loginStatus);
	}

	@When("user enters correct email and password on the login page")
	public void enterCorrectCredentials() {
		login.enterCredentials(ConfigReader.getEmail(), ConfigReader.getPassword());
	}
	
	@And("click on sign in button")
	public void clickTheSignIn() {
		login.clickContinue();
	}
	
	@Then("user should be able to navigate to the home page")
	public void verifyHomePage() {
		
		HomePage home = new HomePage(driver);
		Helper.implicitWait(driver, 40);
		
		assertTrue(home.isHomePageDisplayed());
	}
	
	@After
	public void tearDown() {
		WebDriverObject.closeDriver();
	}
}
