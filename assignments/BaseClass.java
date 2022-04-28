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

public class BaseClass {

	public ChromeDriver driver;//initialization
	String filename;
	

	@DataProvider(name="getData")
	public String[][] getData() throws IOException
	{
		String[][] d=ReadExcel.readExcel(filename);
		return d;
		
	}
	
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void preCondition(String url,String uname,String pass)
	{
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//login page
		driver.get(url);
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys(uname);
		
		driver.findElement(By.id("password")).sendKeys(pass);
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//next page
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
	
	@AfterMethod(enabled=false)
	public void postCondition() throws InterruptedException
	{
		Thread.sleep(4000);
		driver.close();
	}
	
	
}
