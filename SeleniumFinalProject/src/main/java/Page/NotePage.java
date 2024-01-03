package Page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilPackage.ElementUtility;
import utilPackage.WaitUtility;

public class NotePage 
{
	
	WebDriver driver;
	//@FindBy(locator="")
	//WebElement elementname;
	@FindBy(xpath="//span[text()='Notes']")
	 WebElement notelink;
	@FindBy(xpath="//a[text()=' Add note']")
	WebElement addnote;
	@FindBy(xpath="//input[@name='title']")
	 WebElement addTitleField;
	@FindBy(xpath="//textarea[@name='description']")
	 WebElement descriptionField;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	 WebElement savebutton;
	@FindBy(xpath="//input[@type='search']")
	WebElement notesearch;
	@FindBy(xpath="//table[@id='note-table']//tbody//tr[1]//td[4]//a[1]")
	WebElement noteedit;
	@FindBy(xpath="//input[@name='title']")
	 WebElement title;
	@FindBy(xpath="//span[@class='fa fa-check-circle']")
	 WebElement savebutton1;
	@FindBy(xpath="//table[@id='note-table']//tbody//tr[1]//td[4]//a[2]")
	WebElement deletesearch;
	@FindBy(xpath="//button[@id='confirmDeleteButton']")
	WebElement confirmdelete;
	@FindBy(xpath="//table[@id='note-table']//tbody//tr[1]//td[2]")
	WebElement titleColumn;
	@FindBy(xpath="//button[text()=' Close']")
	WebElement closeButton;
	@FindBy(xpath="//table[@id='note-table']//tbody//tr[1]//td[1]")
	WebElement noElement;
	@FindBy(xpath="//button[@class='close']")
	WebElement recorddelete;
	ElementUtility elementutil;
	WaitUtility waitutil;
	//use wait and element utility
	
	public NotePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);//@FindBy is work by PageFactory to initiate it
		waitutil =new WaitUtility(driver);
		elementutil=new ElementUtility(driver);
		
	}
	public String addNote(String title,String description)
	{
		waitutil.waitForClick(addnote);
		  addnote.click();
		  addTitleField.sendKeys(title);
		  descriptionField.sendKeys(description);
		  savebutton.click();
		  waitutil.waitForClick(closeButton);//wait until view close button
		  closeButton.click();//click the close button
		  clickNoteLink();// call note 
		  String actual=search(title);
		  System.out.println(actual);//To see what we get
		  return actual;//return the searched string
		  
	}
	public String editNote(String searchvalue,String editvalue)
	{
		 waitutil.waitForClick(notesearch);
		 notesearch.sendKeys(searchvalue);
		 noteedit.click();
		 title.clear();//clear content
		 title.sendKeys(editvalue);//add edited content
		 savebutton1.click();
		 waitutil.waitForClick(closeButton);
		 closeButton.click();
		 clickNoteLink(); 
		 String actual=search(editvalue);
		System.out.println(actual);
		return actual;
		  
	}
	public String deleteNote(String searchvalue)
	{
		  notesearch.sendKeys(searchvalue);
		  deletesearch.click();
		  confirmdelete.click();
		  waitutil.waitForClick(recorddelete);
		  recorddelete.click();
		  String message=noElement.getText();
		  System.out.println(message);
		  return message;
		  
	}
	public void clickNoteLink()//to call note every time
	{
		notelink.click();
	}

	public String search(String searchvalue) 
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(250));
	wait.until(ExpectedConditions.visibilityOf(notesearch));
	notesearch.sendKeys(searchvalue);
	By locator=By.xpath("//table[@id='note-table']//tbody//tr//td//a[contains(text(),'"+searchvalue+"')]");
	waitutil.visibilityWait(locator);
	List<WebElement> notetable=driver.findElements(By.xpath("//table[@id='note-table']//tbody//tr//td//a[contains(text(),'"+searchvalue+"')]"));
	waitutil.visibilityWait(notetable);
		int row=elementutil.getTableDataRowCount(notetable, searchvalue);
		String message="";
		if(row!=0) 
		{
			WebElement tableRow=driver.findElement(By.xpath("//table[@id='note-table']//tbody//tr["+row+"]//td[2]"));
			message=tableRow.getText();
			System.out.println(message);
			
		}
		return message;
	}

}

