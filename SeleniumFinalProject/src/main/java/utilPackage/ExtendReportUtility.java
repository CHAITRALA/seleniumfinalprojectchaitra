package utilPackage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//The ExtendReportUtility class appears to be a utility class for creating and configuring Extent Reports,
//which is a reporting library commonly used in Selenium and other testing frameworks to generate interactive and visually appealing HTML reports. 
public class ExtendReportUtility {
//This method is responsible for creating an instance of ExtentReports and configuring its settings.	
	public static ExtentReports createExtentReports()
	{
		String path =System.getProperty("user.dir")+"\\extent-reports\\extent-report.html";// Specifies the path where the Extent Report HTML file will be generated. It uses the current working directory (user.dir) and appends the folder name (extent-reports) and file name (extent-report.html).
		//path to the report
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);//Creates an instance of ExtentSparkReporter and sets the path for the report.
		reporter.config().setReportName("Web Automation Results");//sets the name of the report displayed in the report.
		reporter.config().setDocumentTitle("Test Results");// Sets the title displayed on the browser tab when viewing the report.
		ExtentReports  extent =new ExtentReports(); //Creates an instance of ExtentReports.
		extent.attachReporter(reporter);// Attaches the previously created ExtentSparkReporter to the ExtentReports instance.

		return extent;//Returns the created ExtentReports instance.
	}
}
/*This utility method is typically called at the beginning of your test suite or test setup to create and configure an Extent Report. Once you have this ExtentReports instance, you can use it to create test logs, add test information, and generate the HTML report at the end of your test execution.*/