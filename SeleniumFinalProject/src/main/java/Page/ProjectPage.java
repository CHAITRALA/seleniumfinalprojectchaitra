package Page;

import java.time.Duration;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilPackage.ElementUtility;
import utilPackage.WaitUtility;

public class ProjectPage {
	
	WebDriver driver;
	@FindBy(xpath="//span[text()='Projects']")
	WebElement project;
	@FindBy(xpath="//span[text()='All Projects']")
	WebElement allproject;
	@FindBy(xpath="//a[@title='Add project']")
	WebElement addproject;
	@FindBy(xpath="//input[@name='title']")
	WebElement addtitlefield;
	@FindBy(xpath="//textarea[@name='description']")
	 WebElement descriptionField;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement savebutton;
	@FindBy(xpath="//input[@type='search']")
	WebElement projectsearch;
	@FindBy(xpath="//table[@id='project-table']//tbody//tr[1]//td[9]//a[1]")
	 WebElement projectedit;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement savebutton1;
	@FindBy(xpath="//table[@id='project-table']//tbody//tr[1]//td[9]//a[2]")
	WebElement deletebutton;
	@FindBy(xpath="//button[@id='confirmDeleteButton']")
	WebElement confirmDelete;
	@FindBy(xpath="//table[@id='project-table']//tbody//tr//td[2]")
	WebElement searchtitle;
	@FindBy(xpath="//button[text()=' Close']")
	WebElement closeButton;
	@FindBy(xpath="//table[@id='project-table']//tbody//tr")
	WebElement noElement;
	@FindBy(xpath="//button[@class='close']")
	WebElement recorddelete;
	@FindBy(xpath="//input[@id='start_date']")
	WebElement startdate;
	WaitUtility waitutil;
	ElementUtility elementutil;//classname objname
	
	
	public ProjectPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutil=new ElementUtility(driver);//object intialisation
		waitutil =new WaitUtility(driver);
	}
	public String addProject(String title,String description,String date)//to add a project and save it
	{
	waitutil.waitForClick(addproject);
	addproject.click();
	addtitlefield.sendKeys(title);
	descriptionField.sendKeys(description);
	elementutil.dateSelect(startdate,date);
	savebutton.click();
	 waitutil.waitForClick(closeButton);
	 
	 closeButton.click();//click the close button
	 clickProjectLink();
	 projectsearch.sendKeys(title);
	//assertion
	 String actualtext=searchtitle.getText();
	 System.out.println(actualtext);
	 return actualtext;
	  
	}
	public void clickProjectLink()//we always need to go to project link so we created it as method
	{
		project.click();
		allproject.click();
	}
	public String editProject(String searchvalue,String editvalue)
	{
	waitutil.waitForClick(projectsearch);
	 projectsearch.sendKeys(searchvalue);
	  projectedit.click();
	  addtitlefield.clear();
	  addtitlefield.sendKeys(editvalue);
	  savebutton1.click();
	  waitutil.waitForClick(closeButton);
	  closeButton.click();
	  clickProjectLink();
	  projectsearch.sendKeys(editvalue);
	  String actual= searchtitle.getText();
	 System.out.println(actual);
	return actual;
	  
	}
	public String deleteProject(String searchvalue)
	{
		waitutil.waitForClick(projectsearch);
	 projectsearch.sendKeys(searchvalue);
	 deletebutton.click();
	 confirmDelete.click();
	 waitutil.waitForClick(recorddelete);
	 clickProjectLink();
	  String message=noElement.getText();
	  System.out.println(message);
	  return message;
	  
	}

}
