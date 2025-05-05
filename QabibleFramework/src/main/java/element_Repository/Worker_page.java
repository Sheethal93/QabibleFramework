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
	@FindBy(xpath="//a[@href='/payrollapp/worker/index']")
	WebElement workersButton;
	
	@FindBy(xpath="//a[@href='/payrollapp/worker/create']")
	WebElement createWorkerButton;
	
	public void clickWorkersButton() {
		workersButton.click();
	}
	
	public void clickCreateWorkerButton(){
		createWorkerButton.click();
	}
	
	
	
	

}
