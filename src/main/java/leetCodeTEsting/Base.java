package leetCodeTEsting;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
public static WebDriver driver;
public static String subFolder;
	
	@BeforeSuite
	public void setUP() {
		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		
	}

//	public void setBrwser() {
//		driver = new ChromeDriver();
//	}
	@AfterSuite
	public void tearDown() {
		System.out.println("tear down"+driver);
		driver.close();
	}
	
	
	
	
	
	
	public void getScreenShot(String fileName) throws IOException {
		if(subFolder==null) {
			LocalDateTime myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
			subFolder = myDateObj.format(myFormatObj);
		}
		
     TakesScreenshot tc = (TakesScreenshot)driver;
     File source= tc.getScreenshotAs(OutputType.FILE);
     File destination = new File("./FailedTestImages/"+subFolder+"/"+fileName);
     FileUtils.copyFileToDirectory(source, destination);
		
	}
	

	
}
