package assignments.week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.EqualsMethod;

public class LearnGroundPlayWithHyperlinks {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Go to Home Page")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.linkText("HyperLink")).click();
		Thread.sleep(5000);
		
		String withoutClickingMe = driver.findElement(By.linkText("Find where am supposed to go without clicking me?")).getAttribute("href");
		System.out.println("where am supposed to go without clicking me?" +withoutClickingMe);
		Thread.sleep(5000);
		
		driver.findElement(By.linkText("Verify am I broken?")).click();
		String verifyBroken = driver.getTitle();
		if (verifyBroken .contains("404") )
			System.out.println("The Link is Broken");
		else
			System.out.println("The Link is not Broken");
		Thread.sleep(5000);
		
		driver.navigate().back();
		
		driver.findElement(By.xpath("(//a[text() =\"Go to Home Page\"])[2]")).click();
		Thread.sleep(5000);
		driver.navigate().back();
		
		List<WebElement> noOfElements = driver.findElements(By.tagName("a"));
		System.out.println("No. Of Links available in this page is: " +noOfElements.size());
		Thread.sleep(5000);
		
		driver.close();
		
		
		
		
		
		

	}

}
