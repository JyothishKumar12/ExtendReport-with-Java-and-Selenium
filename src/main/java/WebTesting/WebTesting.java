package WebTesting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(ListenerTest.class)
public class WebTesting extends ExtndReport{

	public static WebDriver driver;
	
	@BeforeTest
	public void setTestDetails() {
		desc = "Google Testing";
		name="Jyothish";
		category="Smoke Test";
		device="Chrome";
	}

	@Test
	public void GoogleTesing() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		Assert.assertEquals(title,"Googile");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
