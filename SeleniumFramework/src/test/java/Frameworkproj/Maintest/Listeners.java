
package Frameworkproj.Maintest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Frameworkproj.properties.ExtentReportNG;

public class Listeners extends BaseTest implements ITestListener {

	ExtentReports extent = ExtentReportNG.getReportObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> extenttest = new ThreadLocal<ExtentTest>();

	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extenttest.set(test);
	}

	
	public void onTestSuccess(ITestResult result) {
		extenttest.get().log(Status.PASS, "Test Passed");
	}


	public void onTestFailure(ITestResult result) {
		extenttest.get().log(Status.FAIL,"Test Failed");
	extenttest.get().fail(result.getThrowable());
	
	try {
		driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	String Filepath = null;
	String testMethodName =result.getMethod().getMethodName();
//	try {
//		Filepath = getScreenshot(result.getMethod().getMethodName(), driver);
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	   //extenttest.get().addScreenCaptureFromPath(Filepath, result.getMethod().getMethodName());
	try {
		extenttest.get().addScreenCaptureFromPath(getScreenshot(testMethodName,driver), result.getMethod().getMethodName());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	}

	public void onTestSkipped(ITestResult result) {

	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}
	
	public void onFinish(ITestContext context) {
extent.flush();
	}

}
