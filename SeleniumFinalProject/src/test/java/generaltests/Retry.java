package generaltests;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
	public class Retry implements IRetryAnalyzer 
	{


	   private static final int    maxTry = 2;//Defines a constant representing the maximum number of retry attempts.
	   private              int    count  = 0;//Represents the current retry count.

	   @Override// Indicates that this method overrides a method in the IRetryAnalyzer interface.
	   public boolean retry (final ITestResult iTestResult) {
//Implements the retry method required by the IRetryAnalyzer interface.
	       if (!iTestResult.isSuccess ()) {//Checks if the test result is not successful (i.e., the test has failed).
	           if (this.count < maxTry) {// Checks if the current retry count is less than the maximum allowed retries.
	     
	               this.count++;//Increments the retry count if the conditions for retrying are met.
	               return true;// Indicates that the test should be retried.
	           }}
	       return false;
	   }}
	//If the test is successful (iTestResult.isSuccess() returns true) or the maximum retry limit is reached, the method returns false, indicating that the test should not be retried.