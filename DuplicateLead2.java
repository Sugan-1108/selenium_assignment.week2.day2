package assignments.week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead2 {

	public static void main(String[] args) throws InterruptedException 
	{
	
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		WebElement elementUsername = driver.findElement(By.xpath("//input[@id = 'username']"));
		elementUsername.sendKeys("Demosalesmanager");
		WebElement elementPassword = driver.findElement(By.xpath("//input[@id = 'password']"));
		elementPassword.sendKeys("crmsfa");
		WebElement elementLogin = driver.findElement(By.xpath("//input[@class = 'decorativeSubmit']"));
		elementLogin.click();
		
		
		WebElement elementCrmLink = driver.findElement(By.xpath("//a[contains(text() , 'CRM/SFA')]"));
		elementCrmLink.click(); 
		
		WebElement elementLeads = driver.findElement(By.xpath("//a[contains(text() , 'Leads')]"));
		elementLeads.click();
		
		driver.findElement(By.xpath("//a[contains(text() , 'Find Leads')]")).click();

		driver.findElement(By.xpath("//span[text() = 'Email']")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("test");
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(5000);
		String firstResultingLead = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'] // a[@class = 'linktext'])[1]")).getText();
		System.out.println("First Resulting Lead is" +firstResultingLead);
		
		driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
		driver.findElement(By.xpath("//a[text() = 'Duplicate Lead']")).click();
		Thread.sleep(5000);
		
		String titleDuplicateLead =driver.findElement(By.xpath("//div[text()='Duplicate Lead']")).getText();
				
		if(titleDuplicateLead.equals("Duplicate Lead") )
		
			System.out.println("The title is" + titleDuplicateLead);
		
		else
			System.out.println("The title is not match with Duplicate Lead");
		
		driver.findElement(By.xpath("//input[@class = 'smallSubmit']")).click();
		Thread.sleep(5000);
		
		String duplicateLeadName = driver.findElement(By.xpath("//span[@id = 'viewLead_firstName_sp']")).getText();
		System.out.println("The Duplicate Lead Name is" +duplicateLeadName);
		
		if(duplicateLeadName .equals(firstResultingLead) )
			System.out.println("Mission Success - Duplicated lead Name is same as Captured Name");
		else
			System.out.println("Mission Failed -  Duplicated lead Name is not same as Captured Name");
		
		driver.close();
		
		
		
	}

}
