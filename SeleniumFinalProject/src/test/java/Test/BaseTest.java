package Test;

//import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.TakesScreenshot;
import constantsVariable.ConstantVariableMethods;
import utilPackage.ElementUtility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseTest {
	WebDriver driver;
 
 @Parameters({"browser"})//
 @BeforeMethod(alwaysRun=true)
  public void beforeTest(@Optional ("chrome")String browser) 
 {
	  
	  if(browser.equals("chrome"))
	  {
		  driver=new ChromeDriver(); 
		  //launch web page
		 
	  }
	  else if (browser.equals("edge"))
	  {
		  driver=new EdgeDriver();	  
		  
	  }
	  else
	  {

	  System.out.println("choose any other browser");
	  }
  

	  
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));//implicit wait
	 // driver.get("https://qalegend.com/crm/index.php");//launch web page  
	  driver.get(ElementUtility.getPropertyValue("baseurl"));
 }
  
 @AfterMethod
 //The provided code defines two methods for taking screenshots in case of test failures in a Selenium framework
	public void takeScreenShotOnFailure(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			takeScreenShotOnFailure(iTestResult.getName());
		}
		//driver.quit();
//This method takes an ITestResult object as a parameter, which is a TestNG interface representing the result of a test method execution.
	}
//If the test result status is a failure (ITestResult.FAILURE), it calls the takeScreenShotOnFailure method, passing the name of the failed test method.
public String takeScreenShotOnFailure(String name) throws IOException {		
//This method takes a String parameter name, representing the name of the test method.
		String dateName = new SimpleDateFormat("yyyy_MM_dd_hh_mm").format(new Date());
//It generates a timestamp (dateName) in the format "yyyy_MM_dd_hh_mm" to be appended to the screenshot file name
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);//takes screenshot
//It uses the TakesScreenshot interface to capture a screenshot from the WebDriver instance (driver).
		String destination =ConstantVariableMethods.screenShot_path + name + dateName + ".png";
//It constructs the destination path for the screenshot using a constant path (ConstantVariableMethods.screenShot_path), the test method name, timestamp, and the ".png" extension.
		File finalDestination = new File(destination);
//It creates a File object for the destination path.
		FileUtils.copyFile(source, finalDestination);
//It copies the source (screenshot) file to the final destination.
		return destination;
//t returns the path of the saved screenshot.
	}
  }


