package assignments.week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundLearnListboxes {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();

		WebElement dropdown1 = driver.findElement(By.id("dropdown1"));
		Select dd1 =new Select(dropdown1);
		dd1.selectByIndex(1);
		Thread.sleep(5000);
		
		WebElement dropdown2 = driver.findElement(By.name("dropdown2"));
		Select dd2 =new Select(dropdown2);
		dd2.selectByVisibleText("Appium");
		Thread.sleep(5000);
		
		WebElement dropdown3 = driver.findElement(By.id("dropdown3"));
		Select dd3 =new Select(dropdown3);
		dd3.selectByValue("4");
		Thread.sleep(5000);
		
		WebElement dropdown4 = driver.findElement(By.xpath("//div[@class = 'example']/select[@class = 'dropdown']"));
		Select dd4 = new Select(dropdown4);
		System.out.println("Number of dropdown options are" +dd4.getOptions().size());
		
			
		driver.findElement(By.xpath("(//div[@class = 'example']/select)[5]")).sendKeys("UFT/QTP");
		Thread.sleep(5000);
		
		WebElement dropdown5 = driver.findElement(By.xpath("(//div[@class = 'example']/select)[6]"));
		Select dd5 =new Select(dropdown5);
		dd5.selectByValue("2");
		dd5.selectByValue("3");
		Thread.sleep(5000);

		driver.close();
		
	}

	
}
