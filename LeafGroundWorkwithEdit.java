package assignments.week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundWorkwithEdit {

	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("email")).sendKeys("test321@gmail.com");
		driver.findElement(By.xpath("//input[@value = 'Append ']")).sendKeys(" Test Leaf",Keys.TAB);
		Thread.sleep(5000); 
		
		String defautText = driver.findElement(By.name("username")).getAttribute("value");
		System.out.println("The default Text is:" +defautText);
		driver.findElement(By.xpath("(//input[@name= 'username'])[2]")).clear();
		
		WebElement elementCheck = driver.findElement(By.xpath("(//input[@type= 'text'])[5]"));
		boolean isEditable = elementCheck.isEnabled();
		Thread.sleep(5000); 
		
		if(isEditable == true)
			
			System.out.println("Field is Editable");
		else
			System.out.println("Field is non-editable");
		
		driver.close();
			
		
		
		

	}

}
