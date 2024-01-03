package Test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Page.LoginPage;
import Page.NotePage;

public class NoteTest extends BaseTest  {
	//add grouping 
	@Test(priority=1)
	  public void addNote()
	  {
		SoftAssert softassert=new SoftAssert();
		 LoginPage lp=new LoginPage(driver);
		  lp.doLogin("admin@admin.com","12345678");
		  NotePage np=new NotePage(driver);
		  np.clickNoteLink();
		 String actual= np.addNote("CRM-New Note chaitra","CRM New Note Added By Chaitra and Neenu");
		 String expected="CRM-New Note chaitra";
		 softassert.assertEquals(actual, expected);
		 softassert.assertAll();  
		 
	  }
	@Test(priority=2)
	
	public void SearchNote()
	{
		LoginPage lp=new LoginPage(driver);
		  lp.doLogin("admin@admin.com","12345678");
		  NotePage np=new NotePage(driver);
		  np.clickNoteLink();
		  String actual=np.search("CRM-New Note chaitra");
		  String expected="CRM-New Note chaitra";
		  Assert.assertEquals(actual, expected);
		  
	} 
	@Test(priority=3)
	  public void EditNote()
	  {
		  LoginPage lp=new LoginPage(driver);
		  lp.doLogin("admin@admin.com","12345678");
		  NotePage np=new NotePage(driver);
		  np.clickNoteLink();
		  String actual=np.editNote("CRM-New Note chaitra","CRM-EDITED NOTE");
		  String expected="CRM-EDITED NOTE";
		  Assert.assertEquals(actual, expected);
	  }
	

	@Test(priority=4)
	  public void deleteNote()
	  {
		 LoginPage lp=new LoginPage(driver);
		  lp.doLogin("admin@admin.com","12345678");
		  NotePage np=new NotePage(driver);
		  np.clickNoteLink();
		  
		 String actual=np.deleteNote("CRM-EDITED NOTE");
		 String expected="No record found.";
		 Assert.assertEquals(actual, expected);
		  
		  
	  }
	
}

