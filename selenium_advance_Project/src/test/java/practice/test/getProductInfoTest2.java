package practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;


public class getProductInfoTest2 {
	
	@Test(dataProvider = "getData")
	public void getProductInfoTest1(String brandName, String productName) throws InterruptedException {
	    WebDriver driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    driver.get("https://www.amazon.in");

	// search_product
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName, Keys.ENTER);

    // capture product info
    String x = "//span[contains(text(),'"+ productName + "')]/ancestor::div[@data-component-type='s-search-result']//span[@class='a-price-whole']";
    String price = driver.findElement(By.xpath(x)).getText();
    System.out.println(price);

    driver.quit();
}

@DataProvider
public Object[][] getData() throws Throwable {
    ExcelUtility eLib = new ExcelUtility();
    int rowCount = eLib.getRowcount("product");

    Object[][] objArr = new Object[rowCount][2];

    for (int i = 0; i < rowCount; i++) {
        objArr[i][0] = eLib.getDataFromExcel("product", i + 1, 0);
        objArr[i][1] = eLib.getDataFromExcel("product", i + 1, 1);
    }

    return objArr;
}

}
