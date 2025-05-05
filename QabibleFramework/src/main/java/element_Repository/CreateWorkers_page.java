package element_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.General_Utilities;

public class CreateWorkers_page {
	WebDriver driver;
	
	General_Utilities gu=new General_Utilities();
	
	public CreateWorkers_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver, this);
	}
	
	@FindBy(id="worker-title")
	WebElement titleDropdown;
	
	public void clickTitleDropdown() {
		titleDropdown.click();
	}
	
	public String getValueofDropdown() {
		 return gu.selectValueFromDropdown(titleDropdown, 3);
		
	}
	
	

}
