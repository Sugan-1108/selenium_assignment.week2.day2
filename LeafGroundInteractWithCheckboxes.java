package assignments.week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundInteractWithCheckboxes {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("((//div[@class = \"example\"])[1]//input)[1]")).click();
		driver.findElement(By.xpath("((//div[@class = \"example\"])[1]//input)[3]")).click();
		Thread.sleep(5000);
		
		Boolean isChecked = driver.findElement(By.xpath("(//div[@class = \"example\"])[2]//input")).isSelected();
		System.out.println("Selenium is Checked:   " +isChecked);
		
		List<WebElement> deSelect = driver.findElements(By.xpath("(//div[@class = \"example\"])[3]//input"));
		for (int i = 0; i < deSelect.size(); i++) 
		{
			if (deSelect.get(i).isSelected() )
			{
			deSelect.get(i).click();
			}
		}
			
		
		Thread.sleep(5000);
		
		List<WebElement> selectAllCheckbox = driver.findElements(By.xpath("(//div[@class = \"example\"])[4]//input"));
		for (int i = 0; i < selectAllCheckbox.size(); i++) 
		{
			selectAllCheckbox.get(i).click();
		}
		
		Thread.sleep(5000);
		driver.close();
		
	}
	


}
