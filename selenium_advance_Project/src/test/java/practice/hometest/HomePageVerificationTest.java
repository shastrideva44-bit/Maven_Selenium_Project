package practice.hometest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

//import com.google.protobuf.Method;

//import com.sun.org.apache.bcel.internal.classfile.Method;

public class HomePageVerificationTest {
	
	    @Test
	    public void homePageTest(Method mtd) {
	        System.out.println(mtd.getName() + " Test Start");
	        String exptectedPage = "Home";
	        
	        WebDriver driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	        driver.get("http://49.249.29.4:8888/");
	        
	        driver.findElement(By.name("user_name")).sendKeys("admin");
	        driver.findElement(By.name("user_password")).sendKeys("admin");
	        driver.findElement(By.id("submitButton")).click();
	        
	        String actTitle = driver.findElement(By.xpath("//a[contains(text(), 'Home')]")).getText();
	        
	        if (actTitle.trim().equals(exptectedPage)) {
	            System.out.println(exptectedPage + " Page is verified==PASS");
	        } else {
	            System.out.println(exptectedPage + " Page is not verified==FAIL");
	        }
	        driver.close();
	        System.out.println(mtd.getName() + "Test End");
	    }

	    @Test  void verifyLogoHomePageTest(Method mtd) {
	        // Implementation for logo verification goes here
	    	 
	 	        System.out.println(mtd.getName() + " Test Start");
	 	      
	 	        
	 	        WebDriver driver = new ChromeDriver();
	 	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	 	        driver.get("http://49.249.29.4:8888/");
	 	        
	 	        driver.findElement(By.name("user_name")).sendKeys("admin");
	 	        driver.findElement(By.name("user_password")).sendKeys("admin");
	 	        driver.findElement(By.id("submitButton")).click();
	 	       
	 	        WebElement status= driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']"));
	 	         if (status.isEnabled()) {
		            System.out.println("Logo  is verified==PASS");
		        } else {
		            System.out.println("Logo Page is not verified==FAIL");
		        }
	 	         driver.close();
		        System.out.println(mtd.getName() + "Test End");
		    }
	    
	}