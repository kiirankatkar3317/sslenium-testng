package Frameworkproj.properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

public static ExtentReports getReportObject() {
	
	String Path = System.getProperty("user.dir") +"\\Reports\\index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(Path);
	reporter.config().setDocumentTitle("Test Results");
	reporter.config().setReportName("Web Automation Results");

	ExtentReports extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Kiran Katkar");
	
    return extent;
}
	
}
