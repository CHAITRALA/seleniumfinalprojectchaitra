package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilPackage.ElementUtility;
import utilPackage.WaitUtility;

public class LoginPage {
	WebDriver driver;	
	@FindBy(xpath="//input[@id='email']")
	 WebElement emailid;
	@FindBy(xpath="//input[@id='password']")
	 WebElement passwordid;
	@FindBy(xpath="//button[@type='submit']")
	 WebElement signIn;
	@FindBy(xpath="//span[text()='Dashboard']")
	 WebElement logged;
	ElementUtility elementutil;
	WaitUtility waitutil;
	

	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);//@FindBy is work by PageFactory to initiate it
		waitutil =new WaitUtility(driver);
		elementutil=new ElementUtility(driver);
	}

	public String doLogin(String email,String password) 
	{
		  
		  emailid.sendKeys(email);
		  passwordid.sendKeys(password);
		  signIn.click();
		  String actual=logged.getText();
		  System.out.println(actual);
		  return actual;
	}
}