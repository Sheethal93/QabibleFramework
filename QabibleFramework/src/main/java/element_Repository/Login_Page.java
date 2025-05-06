package element_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	
WebDriver driver;
	
	public Login_Page(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
		
	
	@FindBy(id="loginform-username")
	WebElement userName;
	
	@FindBy(id="loginform-password")
	WebElement password;
	
	@FindBy(name="login-button")
	WebElement loginButton;
	
	

	public void input_Username(String username1) 
	{
		userName.sendKeys(username1);

	}

	public void input_Password(String pasword1) 
	{
		password.sendKeys(pasword1);
	}

	public Home_page click_Login() 
	{
		loginButton.click();
		
		return new Home_page(driver);
		
	}

}
