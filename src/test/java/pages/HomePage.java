package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.Helper;

public class HomePage extends BaseClass<HomePage> {
	
	private final By HOME_ELMNT = By.id("qa-HOME-CONTAINER");
	private final By NEW_ELMNT = By.id("qa-CREATE_NOTE");
	private final By NOTE_ELMNT = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/ul[1]/li[1]/button[1]");
	private final By TITLE_ELMNT = By.cssSelector("textarea[placeholder='Title']");
	private final By DESC_ELMNT = By.className("para");
	private final By PROFILE_ELMNT = By.cssSelector("div[aria-controls='qa-ACTIONS_MODAL']");
	private final By SIGNOUT_ELMNT = By.id("qa-ACCOUNT_DROPDOWN_LOGOUT");
	private final By WITHOUT_SYNC_ELMNT = By.id("qa-LOGOUT_CONFIRM_DIALOG_CANCEL");
	private final By ALL_NOTES = By.id("qa-NAV_ALL_NOTES");
	private final By NOTES_LIST = By.className("rv-sticky-node-list");

	private final String TITLE = "TODO List";
	private final String TASKS = "Go to Malta\nVisit Videoslot office\nPlay poker\nWin 1 MILLION\nChill with the team :D";
	private final String IFRAME = "qa-COMMON_EDITOR_IFRAME";
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void clickNewButton() {
		driver.findElement(NEW_ELMNT).click();
	}
	
	public void clickNoteButton() {
		driver.findElement(NOTE_ELMNT).click();
	}
	
	public void typeTitle() {
		swithToIframe(driver, IFRAME);
		driver.findElement(TITLE_ELMNT).sendKeys(TITLE);
	}
	
	public void typeTasks() {
		driver.findElement(DESC_ELMNT).sendKeys(TASKS);
		exitIframe(driver);
	}
	
	public void clickProfileButton() {
		WebElement e = driver.findElement(PROFILE_ELMNT);
		WebElement sp = e.findElements(By.tagName("span")).get(0);
		sp.click();
	}
	
	public void clickSignOut() {
		driver.findElement(SIGNOUT_ELMNT).click();
	}
	
	private void swithToIframe(WebDriver driver, String iframeId) {
		Helper.switchToIframe(driver, iframeId);
	}
	
	private void exitIframe(WebDriver driver) {
		Helper.exitIFrame(driver);
	}
	
	public boolean isHomePageDisplayed() {
		return driver.findElements(HOME_ELMNT).size() > 0;
	}
	
	private WebElement getElementFromHomePageToVerify() {
		return driver.findElement(HOME_ELMNT);
	}
	
	public void waitHomePageToLoad() {
		
		Helper.implicitWait(driver, 40);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		
        try {
        	wait.until(ExpectedConditions.visibilityOf(getElementFromHomePageToVerify()));
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}
	
	public void waitToSignOut() {
		
		if(driver.findElements(SIGNOUT_ELMNT).size() > 0) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(SIGNOUT_ELMNT)));
		}
	}
	
	public void clickExitWithoutSynching() {
		if(driver.findElements(WITHOUT_SYNC_ELMNT).size() > 0)
			driver.findElement(WITHOUT_SYNC_ELMNT).click();
	}
	
	public void clickNotesOnSideBar() {
		driver.findElement(ALL_NOTES).click();
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
