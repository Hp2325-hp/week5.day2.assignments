package week5.day2.assignments;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class CreateContact extends BaseClass{

	//set the file name
	@BeforeTest
	public void setFileName()
	{
		filename="CreateContact";
	}
	
	@Test(dataProvider="getData")
	public  void createContact(String fname,String lname,String cfname, String clname,String department,String desc, String mailid,String city,String impnotes) throws InterruptedException {
	
		
		System.out.println("Create Contact");
		//click contacts
		driver.findElement(By.xpath("//div/a[text()='Contacts']")).click();
		//click create contact
		driver.findElement(By.xpath("//a[text()='Create Contact']")).click();
		//providing first name
		driver.findElement(By.id("firstNameField")).sendKeys(fname);
		//providing last name
		driver.findElement(By.id("lastNameField")).sendKeys(lname);
		//providing first local name
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys(cfname);
		//providing last local name
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys(clname);
		//department
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys(department);
		//Description
		driver.findElement(By.id("createContactForm_description")).sendKeys(desc);
		//mail id 
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys(mailid);
		//state selection
		WebElement we=driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		
		Select s=new Select(we);
		
		s.selectByVisibleText(city);
		
		driver.findElement(By.xpath("//td/input[@name='submitButton']")).click();
		
		driver.findElement(By.xpath("//div/a[text()='Edit']")).click();
		
		driver.findElement(By.id("updateContactForm_description")).clear();
		
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys(impnotes);
		
		driver.findElement(By.xpath("//tr//input[@name='submitButton']")).click();
		//get title
		String title=driver.getTitle();
		
		System.out.println(title);
		
	}

}
