package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.HelperIFrame;
import util.HelperSeleniumAction;
import util.HelperWait;

public class HomePage extends BaseClass<HomePage> {
	
	private final By HOME_ELMNT = By.id("qa-HOME-CONTAINER");
	private final By NEW_ELMNT = By.id("qa-CREATE_NOTE");
	private final By SIGNOUT_ELMNT = By.id("qa-ACCOUNT_DROPDOWN_LOGOUT");
	private final By WITHOUT_SYNC_ELMNT = By.id("qa-LOGOUT_CONFIRM_DIALOG_CANCEL");
	private final By ALL_NOTES = By.id("qa-NAV_ALL_NOTES");
	
	private final By DESC_ELMNT = By.className("para");
	private final By NOTES_LIST = By.className("rv-sticky-node-list");
	
	private final By TITLE_ELMNT = By.cssSelector("textarea[placeholder='Title']");
	private final By PROFILE_ELMNT = By.cssSelector("div[aria-controls='qa-ACTIONS_MODAL']");

	private final By NOTE_ELMNT = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/ul[1]/li[1]/button[1]");

	private final String TITLE = "TODO List";
	private final String TASKS = "Go to Malta\nVisit Videoslot office\nPlay poker\nWin 1 MILLION\nChill with the team :D";
	private final String IFRAME = "qa-COMMON_EDITOR_IFRAME";
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void clickNewButton() {
		HelperSeleniumAction.click(driver, NEW_ELMNT);
	}
	
	public void clickNoteButton() {
		HelperSeleniumAction.click(driver, NOTE_ELMNT);
	}
	
	public void typeTitle() {
		swithToIframe(driver, IFRAME);
		HelperSeleniumAction.typeOnText(driver, TITLE_ELMNT, TITLE);
	}
	
	public void typeTasks() {
		HelperSeleniumAction.typeOnText(driver, DESC_ELMNT, TASKS);
		exitIframe(driver);
	}
	
	public void clickProfileButton() {
		WebElement e = driver.findElement(PROFILE_ELMNT);
		WebElement sp = e.findElements(By.tagName("span")).get(0);
		sp.click();
	}
	
	public void clickSignOut() {
		HelperSeleniumAction.click(driver, SIGNOUT_ELMNT);
	}
	
	private void swithToIframe(WebDriver driver, String iframeId) {
		HelperIFrame.switchToIframe(driver, iframeId);
	}
	
	private void exitIframe(WebDriver driver) {
		HelperIFrame.exitIFrame(driver);
	}
	
	public boolean isHomePageDisplayed() {
		return driver.findElements(HOME_ELMNT).size() > 0;
	}
	
	private WebElement getElementFromHomePageToVerify() {
		return driver.findElement(HOME_ELMNT);
	}
	
	public void waitHomePageToLoad() {
		
		HelperWait.implicitWait(driver, 40);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		
        try {
        	wait.until(ExpectedConditions.visibilityOf(getElementFromHomePageToVerify()));
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}
	
	public void waitToSignOut() {
		
		if(driver.findElements(SIGNOUT_ELMNT).size() > 0) {
			HelperWait.explicitWaitForVisibility(driver, SIGNOUT_ELMNT, 5);
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//			wait.until(ExpectedConditions.visibilityOf(driver.findElement(SIGNOUT_ELMNT)));
		}
	}
	
	public void clickExitWithoutSynching() {
		if(driver.findElements(WITHOUT_SYNC_ELMNT).size() > 0)
			HelperSeleniumAction.click(driver, WITHOUT_SYNC_ELMNT);
	}
	
	public void clickNotesOnSideBar() {
		HelperSeleniumAction.click(driver, ALL_NOTES);
	}
	
	public void clickTheNote() {
		WebElement e = driver.findElement(NOTES_LIST);
		int a = e.findElements(By.className("rv-sticky-leaf-node")).size();
		WebElement el = e.findElements(By.className("rv-sticky-leaf-node")).get(a - 1);
		el.click();
	}
	
	public String verifyNote() {
		return driver.findElement(TITLE_ELMNT).getText();
	}
}
