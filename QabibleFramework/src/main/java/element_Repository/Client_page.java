package element_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.General_Utilities;

public class Client_page {

	WebDriver driver;

	General_Utilities gu = new General_Utilities();

	public Client_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	

	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchButtton;

	@FindBy(xpath = "//a[@href='/payrollapp/client/create']")
	WebElement createClientButton;
	
	@FindBy(id="client-require_po")
	WebElement requirePoCheckbox;

	

	public String getTextofClientsButton() {
		return gu.getTextOfWebElements(searchButtton);
	}

	public void clickCreateClientButton() {
		//gu.clickAnElement(createClientButton);
		gu.javascriptClick(driver, createClientButton);
	}
	
	
	
	public void clickRequirePoCheckbox() {
	//	gu.waitForElementVisible(driver, requirePoCheckbox, 1000);
		gu.scrollToElement(driver, requirePoCheckbox);
		gu.clickAnElement(requirePoCheckbox);
	
	}
	
	public boolean isclickRequirePoCheckboxSelected() {
		return gu.isElementSelected(requirePoCheckbox);
	}
	
}
