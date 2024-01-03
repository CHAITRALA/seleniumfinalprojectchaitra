package Test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Page.LoginPage;

import constantsVariable.ConstantVariableMethods;
import utilPackage.ExcelRead;

public class LoginTest extends BaseTest
{
  @Test(priority=1,dataProvider="dp")
  public void  verifyLogin(String email,String password)
  {
	 LoginPage lp=new LoginPage(driver);
	 String actual= lp.doLogin(email,password);
	 String expected="Dashboard";
	 Assert.assertEquals(actual, expected);
	  //Add data provider
	  //add assertions
  }  
	  @DataProvider//from where we need to take data for this test is provided by dp
	   public Object[][] dp() throws InvalidFormatException, IOException
	  {
		 Object [][] data= ExcelRead.getDataFromExcel(ConstantVariableMethods.excel_path,"Sheet1");
		 return data;
	  }
	  
  }

