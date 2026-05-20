package practice.hometest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

//import com.google.protobuf.Method;

//import com.sun.org.apache.bcel.internal.classfile.Method;

public class HomePageSampleTest_HardAssert  {
	
	    @Test
	    public void homePageTest(Method mtd) {
	    	 System.out.println(mtd.getName() + " Test Start");
	 	      
		        System.out.println("step-1");
		        System.out.println("step-2");
		       Assert.assertEquals("Home", "Home"); 
		        System.out.println("step-3");
		        Assert.assertEquals("Home-CRM", "Home-CRM"); 
		        System.out.println("step-4");
	       
	        System.out.println(mtd.getName() + "Test End");
	    }

	    @Test
	    public void verifyLogoHomePageTest(Method mtd) {
	        // Implementation for logo verification goes here
	    	 System.out.println(mtd.getName() + " Test Start");
		        System.out.println("step-1");
		        System.out.println("step-2");
		        System.out.println("step-3");
		        System.out.println("step-4");
		        
	 	       
		        System.out.println(mtd.getName() + "Test End");
		    }
	    
	}