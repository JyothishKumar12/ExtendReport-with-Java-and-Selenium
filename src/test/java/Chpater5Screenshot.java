import java.io.File;
import java.io.IOException;

import javax.swing.plaf.basic.BasicBorders.MarginBorder;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.MarkupHelper;
//import com.aventstack.extentreports.observer.entity.MediaEntity.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chpater5Screenshot {

	public static WebDriver driver;
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://yts.mx/browse-movies");
		
		ExtentReports extentReports = new ExtentReports();
		File file = new File("./Reports/report3.html");
		ExtentSparkReporter exSparkReporter = new ExtentSparkReporter(file);
		extentReports.attachReporter(exSparkReporter);
		
		extentReports.createTest("Screen shot Test").addScreenCaptureFromPath(captureScreenshots()).info("Google screenshot");
		extentReports.createTest("Screen shot Test1").addScreenCaptureFromPath(captureScreenshots(),"YTS FRONT PAGE").info("Yts shot");
		

		extentReports.createTest("Screen shot Test2","In log level").info("yts").fail(MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshots()).build());
		extentReports.flush();
		driver.close();
	}

	
	public static String captureScreenshots() throws IOException {
		
		TakesScreenshot tc = (TakesScreenshot) driver;
		File sourceImg =	tc.getScreenshotAs(OutputType.FILE);
		File destImg = new File("./screenShots/"+"Yts.png");
		FileUtils.copyFile(sourceImg, destImg);
		System.out.println("Captured success fully");
		return destImg.getAbsolutePath();
	}
	
}
