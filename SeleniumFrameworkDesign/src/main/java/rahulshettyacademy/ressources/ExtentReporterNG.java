package rahulshettyacademy.ressources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	
	public static ExtentReports getReporterObject() {
		
		String path="//home//chaima//eclipse-workspace//SeleniumFrameworkDesign//src//main//java//rahulshettyacademy//ressources//ExtentReporterNG.java"+"//reports//index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "chaima ammar");
		return extent;
	}
	
}
