import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Chapter8MultipleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExtentReports extentReports = new ExtentReports();
		File file = new File("./Reports/AlltheTests.html");
		ExtentSparkReporter spReport = new ExtentSparkReporter(file);
		ExtentSparkReporter spReport_failed = new ExtentSparkReporter("./Reports/failedTest.html");
		spReport_failed.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
		
		ExtentSparkReporter spReport_passed = new ExtentSparkReporter("./Reports/passedTest.html");
		ExtentSparkReporter spReport_skipped = new ExtentSparkReporter("./Reports/skippedTest.html");
		spReport_failed.filter().statusFilter().as(new Status[] {Status.SKIP}).apply();
		extentReports.attachReporter(spReport,spReport_failed,spReport_passed,spReport_skipped );
		
		extentReports.createTest("TEST FOR PASS").assignAuthor("Lucky").assignCategory("smoke").assignDevice("chrome").pass("passed");
		extentReports.createTest("TEST FOR Fail").assignAuthor("Lucy").assignCategory("Regression").assignDevice("chrome").fail("failed");
		extentReports.createTest("TEST FOR Skip").assignAuthor("Lu").assignCategory("sanity").assignDevice("chrome").skip("skipped");
		
		extentReports.flush();

	}

}
