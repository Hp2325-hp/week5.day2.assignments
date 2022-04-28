package week5.day2.assignments;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowBaseClass {

	String filename;
	public ChromeDriver driver;
	
	@DataProvider(name="getData")
	public String[][] getData() throws IOException
	{
		String[][] d=ReadExcel.readExcel(filename);
		return d;
		
	}
	
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void preCondition(String url,String username,String password) throws InterruptedException
	{
		
		// Webdriver setup
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// url
		driver.get(url);
		driver.manage().window().maximize();

		// username and password
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void afterMethod() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
	}
}
