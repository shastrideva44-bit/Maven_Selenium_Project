package practice.Testng;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.io.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleTestForScreenShot {

    @Test
    public void amazonTest() throws Throwable {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.co.in/");
        driver.manage().window().maximize();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
     

        // step-1 : type casting
        TakesScreenshot ts = (TakesScreenshot) driver;

        // step-2 : capture screenshot
        File src = ts.getScreenshotAs(OutputType.FILE);
              String path="E:\\ECLIPSE\\AUTOMATION IN SELENIUM\\selenium_advance_Project\\Screenshot";
        // step-3 : create destination path
        File dest = new File(path + "\\google.jpeg");

        // step-4 : copy screenshot
        FileHandler.copy(src, dest);
        driver.quit();

        System.out.println("Screenshot taken successfully");
    }
}