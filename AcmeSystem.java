package assignments.week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AcmeSystem {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://acme-test.uipath.com/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("(//input[@class=\"form-control \"])[1]")).sendKeys("kumar.testleaf@gmail.com");
		driver.findElement(By.xpath("(//input[@class=\"form-control \"])[2]")).sendKeys("leaf@12");
		
		driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]")).click();
		
		System.out.println("The Title of the page is" + driver.getTitle());
		
		driver.findElement(By.xpath("//a[text()=\"Log Out\"]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.close();
		

	}

}
