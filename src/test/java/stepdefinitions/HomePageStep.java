package stepdefinitions;

import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


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

public class HomePageStep {
	
	private WebDriver driver = null;
	private HomePage home = null;
	private LoginPage login = null;
	private final String TITLE = "TODO List";
	
	@Before()
	public void init() {
		driver = WebDriverObject.getInstance();
		login = new LoginPage(driver);
		home = new HomePage(driver);
	}
	
	@Given("the user is on home page")
	public void userIsOnHomePage() {
		
		driver.get(ConfigReader.getUrl());
		driver.manage().window().maximize();
		login.clickLoginLink();
		login.enterCredentials(ConfigReader.getEmail(), ConfigReader.getPassword());
		login.clickContinue();
		home.waitHomePageToLoad();
		home.isHomePageDisplayed();
	}
	
	@When("user clicks on New")
	public void clickNew() {
		home.clickNewButton();
		Helper.implicitWait(driver, 5);
	}
	
	@And("click on Note")
	public void clickNoteFeature() {
		home.clickNoteButton();
		Helper.implicitWait(driver, 5);
	}
	
	@And("writes a todo list")
	public void writeTitleAndTask() {
		home.typeTitle();
		home.typeTasks();
	}
	
	@And("clicks on the profile on top left")
	public void clickProfileButton() {
		home.clickProfileButton();
	}
	
	@And("click sign out")
	public void clickSignOut() {
		Helper.implicitWait(driver, 5);
		home.clickSignOut();
		home.clickExitWithoutSynching();
	}
	
	@Then("user should be logged out")
	public void verifyUserIsSignedOut() {
		boolean signInButton = login.verifyLogInLink();
		Helper.implicitWait(driver, 20);
		home.waitToSignOut();
		assertTrue(signInButton);
	}

	@When("clicks on the notes section")
	public void clickAllNotes() {
		home.clickNotesOnSideBar();
	}
	
	@And("clicks on the note we wrote")
	public void clickOnTheNoteWeWrote() {
		home.clickTheNote();
	}
	
	@Then("verify the note")
	public void verifyNote() {
		String noteTitle = home.verifyNote();
		assertEquals(TITLE, noteTitle);
	}
	
	@After
	public void tearDown() {
		WebDriverObject.closeDriver();
	}
}
