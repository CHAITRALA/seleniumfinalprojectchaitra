package utilPackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility 
{
	WebDriver driver;
	public WaitUtility (WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void waitForClick(WebElement waitVar)
	{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(250));
	wait.until(ExpectedConditions.elementToBeClickable(waitVar));
	}
//expected conditions	
	public void visibilityWait(By locator)
	{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(250));
	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public void visibilityWait(List<WebElement> waitlist)
	{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(250));
	wait.until(ExpectedConditions.visibilityOfAllElements(waitlist));
	}
	
	public void selectWait(WebElement waitSel)
	{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(250));
	wait.until(ExpectedConditions.elementToBeSelected(waitSel));
	}
	
	
	public void frameWait(WebElement waitFrame)
	{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(250));
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(waitFrame));

	}
	
	
}
