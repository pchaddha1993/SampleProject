package GoogleSearch;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
	public static void main(String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C://Users//webil//Documents//Selenium//Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.name("q")).sendKeys("JAVA");
		Thread.sleep(10000);
		List <WebElement> list = driver.findElements(By.xpath("//div[@class='mkHrUc']//ul//li/descendant::div[@class='wM6W7d']"));
		System.out.println(list.size());
		for(int i=0; i<list.size();i++)
		{
			String listItem = list.get(i).getText();
			System.out.println(listItem);
			if(listItem.contains("javascript"))
			{
				list.get(i).click();
				break;
			}
		}
		
	}
	

}
