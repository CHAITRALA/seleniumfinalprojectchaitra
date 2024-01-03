package generaltests;

	import java.io.IOException;
	import java.util.*;

	import org.openqa.selenium.WebDriver;
	import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.Status;

import Test.BaseTest;
import utilPackage.ExtendReportUtility;
	

	public class Listener extends BaseTest implements ITestListener 
	{
	ExtentTest test;
	ExtentReports extent=ExtendReportUtility.createExtentReports();//Initializes an instance of ExtentReports by calling the createExtentReports method from the ExtendReportUtility class. This method is expected to create and configure the ExtentReports instance.
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
//Uses a ThreadLocal to store and retrieve the ExtentTest instance. This ensures that each thread (test execution) has its own instance of ExtentTest.

	public void onTestStart(ITestResult result) {
//Overrides the onTestStart method from the ITestListener interface.
//Creates a new test in the Extent Report with the test method name obtained from the ITestResult.	
	ITestListener.super.onTestStart(result);
	test =extent.createTest(result.getMethod().getMethodName());
	extentTest.set(test);

	}

	public void onTestSuccess(ITestResult result) {
//Overrides the onTestSuccess method.
//Logs a "Test Passed" message in the Extent Report when the test is successful.	
	ITestListener.super.onTestSuccess(result);
	extentTest.get().log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {
//: Overrides the onTestFailure method.
//Logs a "Test Failed" message and logs the details of the failure in the Extent Report.
	
	ITestListener.super.onTestFailure(result);
	extentTest.get().log(Status.FAIL, "Test Failed");
	extentTest.get().fail(result.getThrowable());//error
	

	}

	public void onTestSkipped(ITestResult result) {
//: Overrides the onTestSkipped method.
//Logs a "Test Skipped" message in the Extent Report when a test is skipped.
	ITestListener.super.onTestSkipped(result);
	extentTest.get().log(Status.SKIP, "Test Skipped");

	}


	public void onFinish(ITestContext context) {
// Overrides the onFinish method.
//Flushes the ExtentReports instance, writing the report to the specified file or location.
	ITestListener.super.onFinish(context);
	extent.flush();
	//is used to erase any previous data on report and create new report
	}
	}

//This listener class can be configured in your TestNG suite XML file to be used during test execution. It integrates with Extent Reports to capture and log test status and details during test execution. Ensure that the ExtendReportUtility and BaseTest classes are appropriately defined and available for this listener to use.
