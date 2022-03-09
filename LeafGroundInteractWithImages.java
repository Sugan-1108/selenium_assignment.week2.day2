package assignments.week2.day2;

import org.jsoup.select.Evaluator.ContainsText;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundInteractWithImages {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("(//div[@class = 'large-6 small-12 columns']/img)[1]")).click();
		Thread.sleep(5000);
		driver.navigate().back();
		
		driver.findElement(By.xpath("(//div[@class = 'large-6 small-12 columns']/img)[2]")).click();
		String getUrl = driver.getCurrentUrl();
		Thread.sleep(5000);
		if(getUrl .contains("pages/Image.html"))
			
			System.out.println("The Image is broken");
		else
			System.out.println("The Image is not broken");
		
		driver.findElement(By.xpath("(//div[@class = 'large-6 small-12 columns']/img)[3]")).click();
		
		Thread.sleep(5000);
		
		driver.close();
	
		
	}

}
