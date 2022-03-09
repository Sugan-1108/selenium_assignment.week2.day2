package assignments.week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
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

		driver.findElement(By.xpath("//span[text() = 'Phone']")).click();
		driver.findElement(By.xpath("//input[@name= 'phoneAreaCode']")).sendKeys("4");
		driver.findElement(By.xpath("(//button[@class = 'x-btn-text'])[7]")).click();
		Thread.sleep(5000);
		
		String firstResultingLead = driver.findElement(By.xpath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first '] // a[@class = 'linktext'])[1]")).getText();
		System.out.println("First Resulting Lead ID is" +firstResultingLead);
		
		driver.findElement(By.xpath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first '] // a[@class = 'linktext'])[1]")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("// a[@class = 'subMenuButtonDangerous']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[contains(text() , 'Find Leads')]")).click();
		
		driver.findElement(By.xpath("//input [@name= 'id']")).sendKeys(firstResultingLead);
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//button[@class = 'x-btn-text'])[7]")).click();
		Thread.sleep(5000);
		
		String noRecords = driver.findElement(By.xpath("//div[text()= 'No records to display']")).getText();
		
		
		if (noRecords.equals("No records to display"))
			System.out.println("Mission Success - Record deleted successfully");
		else
			System.out.println("Mission Failure - Record not deleted");
		
		driver.close();
		
		
		
	}

}
