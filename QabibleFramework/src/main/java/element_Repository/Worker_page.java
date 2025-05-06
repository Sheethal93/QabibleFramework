package element_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Worker_page {
	
	WebDriver driver;
	
	
	public Worker_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//a[@href='/payrollapp/worker/create']")
	WebElement createWorkerButton;
	
	
	
	public CreateWorkers_page clickCreateWorkerButton(){
		createWorkerButton.click();
		return new CreateWorkers_page(driver);
	}
	
	
	
	

}
