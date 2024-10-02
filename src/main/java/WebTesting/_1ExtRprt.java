package WebTesting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.observer.entity.MediaEntity.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class _1ExtRprt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExtentReports extentReport = new ExtentReports();
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("./TestReports/demonTest.html");
		extentReport.attachReporter(extentSparkReporter);
		ExtentTest test = extentReport.createTest("Navigate to Twitter");
		test.assignAuthor("Jyothish");
		test.assignCategory("smoke testing");
		test.assignCategory("Chrome");
		test.pass("Logo is present");
		test.pass("Login success");
		
		extentReport.createTest("Navigate to Instagram");
		test.assignAuthor("Jyothish");
		test.assignCategory("smoke testing");
		test.assignCategory("Chrome");
		test.pass("Navigation passed");
		test.fail("login faile",MediaEntityBuilder.createScreenCaptureFromPath("./screenShots/Yts.png").build());
		extentReport.flush();
	
}
}