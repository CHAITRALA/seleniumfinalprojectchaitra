package utilPackage;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import constantsVariable.ConstantVariableMethods;

public class ElementUtility 
{
	WebDriver driver;
	
	public ElementUtility (WebDriver driver)
	{
		this.driver=driver;
		
	}
	//for scroll method
	public void scroll(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",element);
	}
	//drop down
	public void dropdownSelectByValue(WebElement value,String a)
	{
	Select ValueDpdwn=new Select(value);	
	ValueDpdwn.selectByValue(a);		
	}
	public void dropdownSelectByIndex(WebElement index,int b)
	{
	Select IndexDpdwn=new Select(index);	
	IndexDpdwn.selectByIndex(b);		
	}
	public void dropdownSelectByVisibleText(WebElement text,String c)
	{
	Select TextDpdwn=new Select(text);	
	TextDpdwn.selectByVisibleText(c);		
	}
	
	public void click()
	{
		WebElement element = driver.findElement(By.id("elementId"));
		element.click();
	}
	public void radioButton(List<WebElement> option,int a)
    {
    	 option.get(a).click();
    }
	
	//config propeties
	public static String getPropertyValue(String key)//The method takes a key parameter, representing the key for which you want to retrieve the value. 
	{
//It uses a constant variable (ConstantVariableMethods.propertyConfig_File) to specify the path to the configuration file.
		File src=new File(ConstantVariableMethods.propertyConfig_File);//It creates a File object (src) with the provided file path.
		Properties pro=new Properties();//pro is an object used to read properties
		try {
			FileInputStream fis = new FileInputStream (src);//Inside a try block, a FileInputStream (fis) is created to read from the configuration file.
			
			pro.load(fis);
		} catch (Exception e) {

			e.printStackTrace();//If an exception occurs during the file reading or property loading, the stack trace is printed.
		}
		
		String value=pro.get(key).toString();//The method then retrieves the value associated with the specified key using pro.get(key).toString().
		return value;//Finally, the method returns the retrieved value.
	}
	

	public void dateSelect(WebElement element,String dateValue) {

		JavascriptExecutor js=(JavascriptExecutor)driver;

		js.executeScript("arguments[0].setAttribute('value','"+dateValue+"');", element);

	}
	public int getTableDataRowCount(List<WebElement> tableRowData ,String expectedValue)
	{
		int counter=0;
		for(int i=0;i<tableRowData.size();i++)
		{
			String value=tableRowData.get(i).getText();
			if(expectedValue.equalsIgnoreCase(value))
			{
				counter=i+1;
				break;
			}
		}
		return counter;
	}
}
