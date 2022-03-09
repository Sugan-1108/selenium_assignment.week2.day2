package assignments.week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver .get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement createNew = driver.findElement(By.xpath("//a[@class = \"_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy\"]"));
		createNew.click();
		driver.findElement(By.xpath("(//input[@class = \"inputtext _58mg _5dba _2ph-\"])[1]")).sendKeys("Sugan");
		driver.findElement(By.xpath("(//input[@class = \"inputtext _58mg _5dba _2ph-\"])[2]")).sendKeys("Gowtham");
		driver.findElement(By.xpath("(//input[@class = \"inputtext _58mg _5dba _2ph-\"])[3]")).sendKeys("testassignment@gmail.com");
		driver.findElement(By.xpath("(//input[@class = \"inputtext _58mg _5dba _2ph-\"])[5]")).sendKeys("testassignment_001");
		
		WebElement elementDropdown = driver.findElement(By.xpath("//select[@id= \"day\"]"));
		Select day = new Select(elementDropdown);
		day.selectByVisibleText("8");
		
		WebElement elementDropdown1 = driver.findElement(By.xpath("//select[@id= \"month\"]"));
		Select month = new Select(elementDropdown1);
		month.selectByVisibleText("Nov");
		
		WebElement elementDropdown2 = driver.findElement(By.xpath("//select[@id= \"year\"]"));
		Select year = new Select(elementDropdown2);
		year.selectByVisibleText("1991");
		
		driver.findElement(By.xpath("//label[text()= \"Male\"]")).click();
		
		
		
	}

}
