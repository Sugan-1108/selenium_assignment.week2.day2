package assignments.week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) throws InterruptedException 
	{

		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		WebElement elementUsername = driver.findElement(By.id("username"));
		elementUsername.sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		
		driver.findElement(By.id("firstNameField")).sendKeys("Sugan");
		driver.findElement(By.id("lastNameField")).sendKeys("Gowtham");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Local First");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Local Second");

		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("IT");
		driver.findElement(By.id("createContactForm_description")).sendKeys("Test Assignment");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("test02@gmail.com");
		
		WebElement elementDropDown = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select dd = new Select(elementDropDown);
		dd.selectByVisibleText("New York");
		Thread.sleep(5000);
		
		driver.findElement(By.className("smallSubmit")).click();
		
		
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Test Update");
		driver.findElement(By.xpath("(//input[@class ='smallSubmit'])[1]")).click();
		
		System.out.println("The Title of the Resulting page is" +driver.getTitle());
		
		
		
		driver.close();
		
		
		
	}

}
