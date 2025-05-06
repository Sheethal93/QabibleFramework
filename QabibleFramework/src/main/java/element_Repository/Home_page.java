package element_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.General_Utilities;

public class Home_page {

	WebDriver driver;

	General_Utilities gu = new General_Utilities();

	public Home_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Welcome to Payroll Application']")
	WebElement welcomeLabelText;
	
	@FindBy(xpath = "//a[@href='/payrollapp/client/index']")
	WebElement clientsButton;
	
	@FindBy(xpath="//a[@href='/payrollapp/worker/index']")
	WebElement workersButton;

	public String getTextWelcomeLabel() {

		return gu.getTextOfWebElements(welcomeLabelText);

	}
	public Client_page clickClientsButton() {
		clientsButton.click();
		return new Client_page(driver);
	}
	
	public Worker_page clickWorkersButton() {
		workersButton.click();
		return new Worker_page(driver);
		
	}
	
	

}
