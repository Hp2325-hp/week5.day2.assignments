package week5.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ServiceNow extends ServiceNowBaseClass{

	@BeforeTest
	public void fileName()
	{
		filename="ServiceNow";
	}
	
	@Test(dataProvider="getData")
	public void serviceNowMethod(String name, String desc) throws InterruptedException {
		
		// Search “incident “ Filter Navigator
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("incident");
		Thread.sleep(2000);
		
		// Click “All”
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		Thread.sleep(2000);
		driver.switchTo().frame("gsft_main");
		
		// Click New button
		driver.findElement(By.id("sysverb_new")).click();
		Thread.sleep(2000);

		// Select a value for Caller and Enter value for short_description
		String incident = driver.findElement(By.id("incident.number")).getAttribute("value");
		driver.findElement(By.xpath("//input[@id='sys_display.incident.caller_id']")).sendKeys(name);
		Thread.sleep(2000);
		driver.findElement(By.id("incident.short_description")).sendKeys(desc);
		Thread.sleep(2000);
		
		// Incident Ticket
		System.out.println(incident);
		
		// Click on Submit button
		driver.findElement(By.id("sysverb_insert")).click();
		Thread.sleep(2000);

		// Search the same incident number in the next search screen as below
		driver.findElement(By.xpath("//div[@class='input-group']/input[@placeholder='Search']")).sendKeys(incident);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='input-group']/input[@placeholder='Search']")).sendKeys(Keys.ENTER);

		// Verify the incident is created successful.
		String confimIncident = driver.findElement(By.xpath("//tbody[@class='list2_body']/tr/td[3]/a")).getText();
		Thread.sleep(1000);
		if (incident.equals(confimIncident))
			System.out.println("The Incident is Created");
		else
			System.out.println("The Incident is not created");


	}

}
