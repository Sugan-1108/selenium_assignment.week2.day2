package assignments.week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead2 {

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
				
		driver.findElement(By.xpath("(//input[ @name= 'firstName' ])[3]")).sendKeys("A");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(5000); 
		
		driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
		Thread.sleep(5000); 
		
		System.out.println("The Title is " +driver.getTitle());

		  
		  if(driver.getTitle().equals("View Lead | opentaps CRM") )
		  {
		  System.out.println("Title matched correctly");
		  }
		  else 
		  {
			  System.out.println("Title not matched");
		  }
		
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		
		driver.findElement(By.xpath("//input[ @id= 'updateLeadForm_companyName' ]")).clear();
		String newCompanyName = "Change Company Name";
		driver.findElement(By.xpath("//input[ @id= 'updateLeadForm_companyName' ]")).sendKeys(newCompanyName);
		
		Thread.sleep(5000); 
		
		driver.findElement(By.xpath("(//input[ @name= 'submitButton' ])[1]")).click();
		Thread.sleep(5000);
		
		String updatedCompanyName = driver.findElement(By.xpath("//span[ @id= 'viewLead_companyName_sp' ]")).getText();
		
		if(updatedCompanyName.contains(newCompanyName))
		{
			System.out.println("Mission Success - Company Name get Updated");
		}
		else
		{
			System.out.println("Mission Failure - Company Name not get updated");
		}
		driver.close();
		
		
	}

	

}
