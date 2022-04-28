package week5.day2.assignments;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteLead extends BaseClass {

	
	@BeforeTest
	public void setFileName()
	{
		filename="DeleteLeads";
	}
	
	
	@Test(dataProvider="getData")
	public void deleteLead(String mobile) throws InterruptedException {

		
		System.out.println("Delete Lead");
		driver.findElement(By.xpath("//div/a[text()='Leads']")).click();
		// click find leads
		driver.findElement(By.xpath("//div//a[text()='Find Leads']")).click();
		// click the phone field
		driver.findElement(By.xpath("//span/span[text()='Phone']")).click();
		// enter mobile no
		driver.findElement(By.xpath("//div/input[@name='phoneNumber']")).sendKeys(mobile);
		// click find leads
		driver.findElement(By.xpath("//td//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		//print the 1st data path address
		String firstIdLink = driver.findElement(By.xpath("//div[contains(@class,'x-grid3-col-partyId')]/a[1]"))
				.getText();// getAttribute("href");
		System.out.println(firstIdLink);
		//select the 1st data
		driver.findElement(By.xpath("//div[contains(@class,'x-grid3-col-partyId')]/a[1]")).click();
		Thread.sleep(2000);
		//delete the record
		driver.findElement(By.xpath("//div[@class='frameSectionExtra']/a[text()='Delete']")).click();
		Thread.sleep(2000);
		//click find leads
		driver.findElement(By.xpath("//div//a[text()='Find Leads']")).click();
		Thread.sleep(2000);
		//searching the lead
		driver.findElement(By.xpath("//div[@class='x-form-element']/input[@name='id']")).sendKeys(firstIdLink);
		driver.findElement(By.xpath("//em/button[text()='Find Leads']")).click();
		Thread.sleep(2000);

		String result = driver
				.findElement(By.xpath("//div[contains(@class,'x-small-editor')]//div[@class='x-paging-info']"))
				.getText();
		Thread.sleep(2000);

		System.out.println(result);
		//record deleted confirmation
		if (result.equals("No records to display"))
			System.out.println(firstIdLink + " Id is deleted");
		else
			System.out.println("Id is not deleted");

	}

}
