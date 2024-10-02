import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Chapter3log {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ExtentReports extentReports = new ExtentReports();
		File file = new File("./Reports/report1.html");
		ExtentSparkReporter exSparkReporter = new ExtentSparkReporter(file);
		extentReports.attachReporter(exSparkReporter);
		extentReports.createTest("Test1")
		.log(Status.FAIL,"PASSED").log(Status.INFO,"info recorded")
		.log(Status.SKIP,"skipped");
		extentReports.flush();
//		Desktop.getDesktop().browse(new File("./Reports/report.html").toURI());

	}

}
