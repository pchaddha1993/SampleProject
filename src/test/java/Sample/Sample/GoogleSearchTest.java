package Sample.Sample;
/*
 * @author: Payal Chaddha
 */
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleSearchTest {
	WebDriver Driver;

@BeforeMethod
public void setup()
{
	System.setProperty("webdriver.chrome.driver","C://Users//webil//Documents//Selenium//Drivers/chromedriver.exe");
	Driver = new ChromeDriver();
	Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	Driver.get("http://www.google.com");
	Driver.manage().window().maximize();
}

@Test(priority=1)
public void verifyPageTitleTest()
{
	String title = Driver.getTitle();
	System.out.println("The page title is="+title);
	Assert.assertEquals(title, "Google");
}

@Test(priority=2)
public void VerifyGoogleLogoTest()
{
	boolean flag = Driver.findElement(By.xpath("//img[@alt='Google']")).isDisplayed();
	Assert.assertTrue(flag);
	
}


@AfterMethod

public void tearDown()
{
	Driver.quit(); 
}

}
