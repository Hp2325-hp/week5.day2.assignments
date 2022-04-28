package week5.day2.assignments;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;


public class CreateLead extends BaseClass{

	
	//The Base class is first and the filename is initialized in base class
	@BeforeTest
	public void filename()
	{
		filename="leadsDetails";//declared
	}
	
	
	@Test(dataProvider="getData")
	public void createLeads(@Optional("Testleaf") String compname,@Optional("No data") String fname,@Optional("No data") String lname,String depart,String desc, String mail) throws InterruptedException {
		
		
		System.out.println("Create Lead");
		//select leads
		driver.findElement(By.linkText("Leads")).click();
		//click create leads
		driver.findElement(By.linkText("Create Lead")).click();
		//providing company name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(compname);
		//provide first name
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		//provide last name
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		//provide local first name
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys(fname);
		//provide local last name
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys(depart);
		//description
		driver.findElement(By.id("createLeadForm_description")).sendKeys(desc);
		//mail id
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(mail);
		//state selection
		WebElement we=driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		
		Select s=new Select(we);
		
		s.selectByVisibleText("New York");
		
		Thread.sleep(2000);
		
		driver.findElement(By.name("submitButton")).click();
		//get title
		String title=driver.getTitle();
		
		System.out.println(title);
		
	}

}
