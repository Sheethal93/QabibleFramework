package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait_Utilities {
	
	public void explicitWaitForPresenceOfElement(WebDriver driver, String locator) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));

	}

}
