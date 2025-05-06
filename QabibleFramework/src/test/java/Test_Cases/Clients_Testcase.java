package Test_Cases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base_Class;
import element_Repository.Client_page;
import element_Repository.Home_page;
import element_Repository.Login_Page;



public class Clients_Testcase extends Base_Class {
	
	
  @Test(groups = "Critical" ,retryAnalyzer =retryQA.Retry.class )
  public void verifyIfTheTextOfTheSearchButtonInTheClientsPage() {
	  Login_Page lp=new Login_Page(driver);
	  lp.input_Username("Carol");
	  lp.input_Password("1q2w3e4r");
		//  lp.click_Login();
	  
	  Home_page hp= lp.click_Login();
	  hp.clickClientsButton();
	  Client_page cp=new Client_page(driver);
	 // cp.clickClientsButton();
	  String actualText=cp.getTextofClientsButton();
	  String expectedText=constant.Constant.expectedTextForSearchButton; //added constant
	  Assert.assertEquals(actualText, expectedText,constant.Constant.assertionErrorMessage);// calling constant as packagename.classname.constant
	 
	
  }
  @Test(groups = "High")
  public void verifyIfRequirePo_checkbox_isSelectedOrNotInCreateClientPage() {
	  Login_Page lp=new Login_Page(driver);
	  lp.input_Username("Carol");
	  lp.input_Password("1q2w3e4r");
	//  lp.click_Login();
	  
	  Home_page hp= lp.click_Login();
	 // hp.clickClientsButton();
	
	  Client_page cp=hp.clickClientsButton();
	 // cp.clickClientsButton();
	  cp.clickCreateClientButton();
	  cp.clickRequirePoCheckbox();
	  
	  Assert.assertEquals(cp.isclickRequirePoCheckboxSelected(), true);
  }
}
