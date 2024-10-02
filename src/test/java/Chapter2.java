import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Chapter2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter exSparkReporter = new ExtentSparkReporter("./Reports/report.html");
		extentReports.attachReporter(exSparkReporter);
		
		extentReports.createTest("TEST 1");
		
		ExtentTest test2=extentReports.createTest("Test 2");
		test2.log(Status.FAIL,"Failed");
		extentReports.createTest("Test3").pass("Passed");
		extentReports.flush();
//		Desktop.getDesktop().browse(new File("report.html").toURI());
	}

}
