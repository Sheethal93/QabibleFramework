package Test_Cases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base_Class;
import element_Repository.CreateWorkers_page;
import element_Repository.Login_Page;
import element_Repository.Worker_page;

public class CreateWorker_Testcase extends Base_Class {
	
  @Test
  public void verifyTheSelectedValuesInCreateWorkerPage() {
	  
	  Login_Page lp=new Login_Page(driver);
	  lp.input_Username("Carol");
	  lp.input_Password("1q2w3e4r");
	  lp.click_Login();
	  
	  Worker_page wp=new Worker_page(driver);
	  wp.clickWorkersButton();
	  wp.clickCreateWorkerButton();
	  
	  
	  
	  CreateWorkers_page cwp=new CreateWorkers_page(driver);
	  cwp.clickTitleDropdown();
	 String actualSelectedValue= cwp.getValueofDropdown();
	 String expectedSelectedValue="Mrs";
	 Assert.assertEquals(actualSelectedValue, expectedSelectedValue, "Selected value in create workers page is not matching");
	 
	  
  }
}
