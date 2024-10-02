package leetCodeTEsting;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



@Listeners(ITestListenersExa.class)
public class LeetCodePage extends Base{

//	@Test()
//	public void leetCodeNavigation() throws IOException {
//		driver.get("https://letcode.in/");
//		driver.manage().window().maximize();
//		String title = driver.getTitle();
//		Assert.assertEquals(title,"let code");
//		
//	}


	@Test(testName = "Google Navigation")
	public void googleResult() {
//		setBrwser();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("Talk to me",Keys.ENTER);
		String title = driver.getTitle();
		Assert.assertEquals(title,"let code");
	}

	
}
