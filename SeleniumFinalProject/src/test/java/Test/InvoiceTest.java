package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Page.InvoicePage;
import Page.LoginPage;

public class InvoiceTest extends BaseTest
{
	String generatedinvoice;
@Test(priority=1)
   public void verifyinvoice() 
  {
	  LoginPage lp = new LoginPage(driver);
	  lp.doLogin("admin@admin.com", "12345678");
	  InvoicePage ip=new InvoicePage(driver);
	  ip.clickInvoice();
	  generatedinvoice=ip.addInvoice("2023-12-27", "2023-12-31", "Chaitra client side","chaitra note in Invoice");
	  ip.clickInvoice();
	  String actualinvoice=ip.search(generatedinvoice);
	  Assert.assertEquals(actualinvoice, generatedinvoice);
  }
//@Test
   public void verifyeditinvoice()
{
	  LoginPage lp = new LoginPage(driver);
	  lp.doLogin("admin@admin.com", "12345678");
	  InvoicePage ip=new InvoicePage(driver);
	  ip.clickInvoice();
	  ip.editInvoice("INVOICE #26", "2023-12-31");
}

@Test(priority=2)
   public void verifydeleteinvoice()
{
	  LoginPage lp = new LoginPage(driver);
	  lp.doLogin("admin@admin.com", "12345678");
	  InvoicePage ip=new InvoicePage(driver);
	  ip.clickInvoice();
	  String actual=ip.deleteInvoice(generatedinvoice);
	  String expected="No record found.";
	  Assert.assertEquals(actual, expected);
}

}

