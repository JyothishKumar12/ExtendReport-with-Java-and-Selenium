package WebTesting;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtndReport {

	public static ExtentReports eReport;	
	public static ExtentTest Test;
	String desc="";
	String name="";
	String category="";
	String device="";

	@BeforeSuite
	public void setReport() {
		eReport = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./TestReports/'WebsiteTestNGTesting.html'/");
		eReport.attachReporter(sparkReporter);
		Test = eReport.createTest("Google Navigation Test");
	}


	@BeforeClass
	public void createTest() {
		
		Test.assignAuthor(name).assignCategory(category).assignDevice(device);
		//Test.pass("Navigate to Google");
		//Test.pass("Instagram");
	}


//	public void setTestStatus(String status,String description) {
//
//		switch(status.toLowerCase()) {
//		case "pass":
//			Test.pass(description);
//			break;
//
//		case "fail":
//			Test.fail(description);
//			break;
//
//		case "info":
//			Test.info(description);
//			break;
//
//		case "warning":
//			Test.warning(description);
//			break;
//
//		default:
//			System.out.println("No status available");
//		}

//	}



	@AfterSuite
	public void flushReport() {
		eReport.flush();
		
	}
}
