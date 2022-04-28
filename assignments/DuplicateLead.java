package week5.day2.assignments;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DuplicateLead extends BaseClass {
//16998
	//set the file name
	@BeforeTest
	public void setFilename()
	{
		filename="DuplicateLeads";
	}
	
	@Test(dataProvider="getData")
	public void duplicateLead(String mail) throws InterruptedException {

		System.out.println("Test case 4");
		System.out.println("Duplicate Lead");
		//click leads
		driver.findElement(By.xpath("//div/a[text()='Leads']")).click();
		//find leads
		driver.findElement(By.xpath("//div//a[text()='Find Leads']")).click();
		Thread.sleep(2000);
		//search by mail
		driver.findElement(By.xpath("//em[@class='x-tab-left']//span[text()='Email']")).click();
		Thread.sleep(2000);
		//entering the mail id
		driver.findElement(By.xpath("//div[@class='x-form-element']/input[@name='emailAddress']"))
				.sendKeys(mail);
		//click find leads
		driver.findElement(By.xpath("//td[@class='x-btn-center']//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		//select the 1st record from the result
		String OFirstName = driver.findElement(By.xpath("//div[contains(@class,'x-grid3-col-firstName')]/a")).getText();
		System.out.println(OFirstName);
		//click on the record
		String FirstId = driver.findElement(By.xpath("//div[contains(@class,'x-grid3-col-partyId')]/a[1]")).getText();
		System.out.println(FirstId);
		driver.findElement(By.xpath("//div[contains(@class,'x-grid3-col-partyId')]/a[1]")).click();
		Thread.sleep(2000);
		//click duplicate
		driver.findElement(By.xpath("//div[@class='frameSectionExtra']/a[text()='Duplicate Lead']")).click();
		Thread.sleep(2000);

		// Title verify
		String title = driver.getTitle();
		System.out.println(title);

		// Click Create Lead
		driver.findElement(By.xpath("//td/input[@value='Create Lead']")).click();
		Thread.sleep(2000);

		// Capture name of Duplicate
		String DFirstname = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();
		System.out.println(DFirstname);
		//verify the record duplicated
		if (OFirstName.equals(DFirstname))
			System.out.println("Both are same");

		else
			System.out.println("Both are not same");

	}

}
