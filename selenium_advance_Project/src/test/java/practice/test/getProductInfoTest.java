package practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

public class getProductInfoTest {

	@Test
	public void getProductInfoTest() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://amazon.in");

		// search product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

		// capture product info
		String x = "//span[text()='iPhone 16 Plus 256 GB: 5G Mobile Phone with Camera Control, A18 Chip and a Big Boost in Battery Life. Works with AirPods; Ultrmarine']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price-whole']";
		String price = driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
	}   


	/*
	@DataProvider
	public Object[][] getData() {
	    Object[][] objArr = new Object[3][2];

	    objArr[0][0] = "iphone";
	    objArr[0][1] = "iPhone 17 Pro 256 GB"; // Shortened for reliability  

	    objArr[1][0] = "iphone";
	    objArr[1][1] = "iPhone 17 Pro 512 GB";

	    objArr[2][0] = "iphone";
	    objArr[2][1] = "iPhone Air 256 GB";

	    return objArr;    
	}
	 */
}