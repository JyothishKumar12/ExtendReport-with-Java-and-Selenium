import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Chapter6Configure {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ExtentReports extentReports = new ExtentReports();
		File file = new File("./Reports/report4.html");
		ExtentSparkReporter spReport = new ExtentSparkReporter(file);
		spReport.config().setTheme(Theme.DARK);
		spReport.config().setReportName("Reporting name");
		spReport.config().setDocumentTitle("Document title");
		spReport.config().setTimeStampFormat("DD-MM-yyyy");
		spReport.config().setCss(".badge-primary{background-color:#fd3259}");
		spReport.config().setJs("document.getElementByClassName('logo')[0].style.display='none';");
		extentReports.attachReporter(spReport);
		extentReports.flush();
		Desktop.getDesktop().browse(new File("./Reports/report4.html").toURI());
	}

}
