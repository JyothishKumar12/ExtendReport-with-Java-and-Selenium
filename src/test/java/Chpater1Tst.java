import java.awt.Desktop;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Chpater1Tst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExtentReports ep = new ExtentReports();
		ExtentSparkReporter sP = new ExtentSparkReporter("demo.html");
		ep.attachReporter(sP);
		ep.createTest("Training").log(Status.INFO,"Yes i am checking");
		ep.createTest("TEST FOR Skip").assignAuthor("Lu").assignCategory("sanity").assignDevice("chrome").skip("skipped");
		ep.flush();
//		Desktop.getDesktop().browse("demo.html");
	}

}
