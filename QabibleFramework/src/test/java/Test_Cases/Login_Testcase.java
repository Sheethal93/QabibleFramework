package Test_Cases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base_Class;
import element_Repository.Home_page;
import element_Repository.Login_Page;

public class Login_Testcase extends Base_Class{
	
  @Test(groups ="Critical" )
  public void verifyloginFeatureIsWorkingWithValidCredentials() {
	  Login_Page lp=new Login_Page(driver);
	  lp.input_Username("Carol");
	  lp.input_Password("1q2w3e4r");
	 lp.click_Login();
	  
	  Home_page hp=new Home_page(driver);
	  String actual=hp.getTextWelcomeLabel();
	  String expected="Welcome to Payroll Application";
	  Assert.assertEquals(actual, expected,"Login function not working as expected with valid users");
	  
	  
  }
}
