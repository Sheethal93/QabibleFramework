package utilities;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class General_Utilities {
	
	public String getTextOfWebElements(WebElement element)
	 {
		 String text=element.getText();
		 return text;
		 
		 
	 }	
	
	public String selectValueFromDropdown(WebElement element,int index ) {
		
		Select select=new Select(element);
		select.selectByIndex(index);
		
		WebElement selectedValue= select.getFirstSelectedOption();
		String text=selectedValue.getText();
		return text;
		
	}
	
	public void clickAnElement(WebElement element) {
		element.click();
		
	}
	
	public void scrollToPixel(WebDriver driver) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		  js.executeScript("window.scrollBy(0,1000)", "");
	}
	
	public void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
	
	public boolean isElementSelected(WebElement element) {
		boolean elementSelected=element.isSelected();
		return elementSelected;
	}
	
	
	
	public void javascriptClick(WebDriver driver, WebElement element) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", element);
	}
	
	
	
	

}
