import java.io.File;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chapter7SystemProperties {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		Capabilities capabilities =((RemoteWebDriver)driver).getCapabilities();
		System.out.println(capabilities.getBrowserName());
		System.out.println(capabilities.getBrowserVersion());
		
		ExtentReports ex = new ExtentReports();
		File file = new File("./Reports/Systemconfig.html");
		ExtentSparkReporter sp = new ExtentSparkReporter(file);
		ex.attachReporter(sp);
		ex.createTest("Test 1").log(Status.PASS,"Demo is passed");
		ex.createTest("Test 1").log(Status.FAIL,"Demo is failed");
		ex.setSystemInfo("Browser ",capabilities.getBrowserName() + capabilities.getBrowserVersion());
		ex.setSystemInfo("version","java.Version");
		ex.setSystemInfo("OS","os.name");
		ex.flush();
		
		
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("Java" + System.getProperty("java.version")));
		
		driver.close();

	}

}
