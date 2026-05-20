package practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class getProductInfoTest1 {
	

	@Test(dataProvider = "getData")
	public void getProductInfoTest1(String brandName, String productName) throws InterruptedException {
	    WebDriver driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    driver.get("https://www.amazon.in");

	    // Search for the product
	    driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName, Keys.ENTER);

	 // capture product info
	    String dynamicXpath = "//span[contains(text(),'" + productName + "')]/ancestor::div[@data-component-type='s-search-result']/descendant::span[@class='a-price-whole']";
	 //   Handling "Flaky" Elements
	   try {
	        String price = driver.findElement(By.xpath(dynamicXpath)).getText();
	        System.out.println("Product: " + productName + " | Price: " + price);
	    } catch (Exception e) {
	        System.out.println("Could not find price for: " + productName);
	    }

	    driver.quit();
	}
	
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
	

}
