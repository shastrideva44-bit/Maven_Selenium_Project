package practice.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrgWithPhoneNumberTest {

	public static void main(String[] args) throws IOException {
	FileInputStream fis = new FileInputStream("E:\\ECLIPSE\\AUTOMATION IN SELENIUM\\selenium_advance_Project\\configAppData\\commonData.properties");
	Properties pObj = new Properties();
	pObj.load(fis);
	//Read the common data from property file
	String BROWSER = pObj.getProperty("browser");
	String URL = pObj.getProperty("url");
	String USERNAME = pObj.getProperty("username");
	String PASSWORD = pObj.getProperty("password");
	
	// generate the random number
	Random random = new Random();
	int randomInt = random.nextInt(10000);
	
	//Read testscript data from excel file 
	FileInputStream fis1 = new FileInputStream("E:\\ECLIPSE\\AUTOMATION IN SELENIUM\\selenium_advance_Project\\configAppData\\VtigerTestCases.xlsx");
	Workbook wb =  WorkbookFactory.create(fis1);
	Sheet sh = wb.getSheet("org");
	Row row = sh.getRow(7);
	String orgName = row.getCell(2).toString()+ randomInt;
	String phoneNumber = row.getCell(3).getStringCellValue();
	wb.close();
	WebDriver driver = null;
	if(BROWSER.equals("chrome")) {
		driver = new ChromeDriver();
	}else if(BROWSER.equals("fireforx")) {
			driver = new FirefoxDriver();
	}else if(BROWSER.equals("edge")) {
				driver = new EdgeDriver();
	}
	// step 1: login to app
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	// step 2: navigate to organization module
	driver.findElement(By.linkText("Organizations")).click();
	
	// step 3: click on "create organization" button
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	 
	 //step 4: enter all the details and create new organization
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
	driver.findElement(By.id("phone")).sendKeys(phoneNumber);
	String shipadd="noida "+randomInt ;
	WebElement ship = driver.findElement(By.name("ship_street"));
	ship.sendKeys(shipadd);
	
	driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click() ;
	
	// VERIFY HEADER PHONEnumber in EXPECTED RESULT(capture the data)
	
	String actPhoneNumber = driver.findElement(By.id("dtlview_Phone")).getText();
	if(actPhoneNumber.equals(phoneNumber)) {
		System.out.println(phoneNumber+ "info is verified==PASS");
	}else {
		System.out.println(phoneNumber + "info is not verified ==FAIL");
	}
	
	
	//step 5: logout
	driver.quit();
	
	
	
	
	}
 
	
	
}
