package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Page.LoginPage;
import Page.ProjectPage;

public class ProjectTest extends BaseTest {
	
	//use soft assert and change test data
  @Test(priority=1,groups="smoke")
  public void addProject() 
  {
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin("admin@admin.com","12345678");
	  ProjectPage pg=new ProjectPage(driver);
	  pg.clickProjectLink();
	  String actual=pg.addProject("CRM New Project","CRM New Project added By Chaitra and Neenu","2023-12-12");
	  String expected="CRM New Project";
	  Assert.assertEquals(actual,expected);
  }
  //add assertions
  
  @Test(priority=2,groups="regression")
  public void editproject() 
  {
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin("admin@admin.com","12345678");
	  ProjectPage pg=new ProjectPage(driver);
	  pg.clickProjectLink();
	  
	  String actual=pg.editProject("CRM New Project", "CRM Edited Project");
	  String expected="CRM Edited Project";
	  Assert.assertEquals(actual,expected);
	 
  }
  @Test(priority=3,groups= {"smoke","regression"},retryAnalyzer = generaltests.Retry.class)
  public void deleteProject() 
  {
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin("admin@admin.com","12345678");
	  ProjectPage pg=new ProjectPage(driver);
	  pg.clickProjectLink();
	  String actual=pg.deleteProject("CRM Edited Project");
	  String expected="No record found.";
	  Assert.assertEquals(actual, expected);
  }
}
