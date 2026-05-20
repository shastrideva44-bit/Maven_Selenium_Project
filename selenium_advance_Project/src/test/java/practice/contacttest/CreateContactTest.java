package practice.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
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
import org.openqa.selenium.support.ui.Select;

public class CreateContactTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
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
		Row row = sh.getRow(1);
		String lastName = row.getCell(2).toString()+ randomInt;
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
		
		// step 2: navigate to CONTACT module
		driver.findElement(By.linkText("Contacts")).click();
		
		// step 3: click on "create organization" button
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		 
		 //step 4: enter all the details and create new organization
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		// VERIFY HEADER PHONE NUMBER EXPECTED RESULT
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		if(actLastName.equals(lastName)) {
			System.out.println(lastName + "header verified is created==PASS");
		}else {
			System.out.println(lastName + "header verified is not created==FAIL");
		}
	
		
		
		//step 5: logout
		driver.quit();
		}

		
		}


