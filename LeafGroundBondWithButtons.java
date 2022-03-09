package assignments.week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundBondWithButtons {

	public static void main(String[] args) throws InterruptedException 
	{
	

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("home")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.linkText("Button")).click();
		Thread.sleep(5000);
		
		Point position = driver.findElement(By.id("position")).getLocation();
		System.out.println("Position of the button is: " +position);
		
		String color = driver.findElement(By.id("color")).getCssValue("background-color");
		System.out.println("Color of the button is: " +color);
		
		Dimension size = driver.findElement(By.id("size")).getSize();
		System.out.println("The Height and width of the button is " +size);
		
		driver.close();
		
		
		
		
		

	}

}
