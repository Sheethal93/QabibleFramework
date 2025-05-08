package base;

import org.testng.annotations.Test;

import utilities.Capture_ScreenshotForFailedTC;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class Base_Class {
 public WebDriver driver;
 
 public static Properties prop;//prop is the ref variable of class Properties
	public static void testBasic() throws IOException {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + File.separator + "src" + 
		File.separator + "main" + File.separator + "resources" +
						File.separator + "Config.properties");
		prop.load(ip);
	}
 
	
  @BeforeMethod(alwaysRun = true) 
  
  @Parameters("browser")
  
  public void beforeMethod(String browserused) throws IOException {
	  testBasic();
	  
	  if (browserused.equals("chrome")) {
		  driver=new ChromeDriver();
		}else if (browserused.equals("edge")) {
			  driver=new EdgeDriver();
			
		}
	  //driver=new ChromeDriver();
	  driver.get(prop.getProperty("Baseurl"));
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
  }

  @AfterMethod(alwaysRun = true) 
  public void afterMethod(ITestResult iTestResult) throws IOException {
	  
	  if (iTestResult.getStatus() == ITestResult.FAILURE) {
		  Capture_ScreenshotForFailedTC css=new Capture_ScreenshotForFailedTC();
		  css.captureScreenShotForFailedTestcase(driver, iTestResult.getName());
			
		}
	  driver.quit();
  }

}
