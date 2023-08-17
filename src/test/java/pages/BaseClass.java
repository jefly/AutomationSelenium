package pages;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseClass<T> {

	protected WebDriver driver = null;
	protected Logger logger = null;
	
	public BaseClass(WebDriver driver) {
		this.driver = driver;
		String className = getClass().getSimpleName();
        logger = LoggerFactory.getLogger(className);
	}
	
}
