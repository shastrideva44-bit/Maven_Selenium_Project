package practice.pom.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SampleTestWithPomFindBys {
	@FindBy(name="user_name")
	WebElement ele1;
	
	@FindBy(name ="user_password")
	WebElement ele2;
		 
	 @FindBys({@FindBy(xpath = "//input[@id='abcd']"), @FindBy(xpath="//input[@type='submit']")}) 
	private WebElement ele3;
	@Test
	public void sampleTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://49.249.28.218:8888/");
		SampleTestWithPomFindBys s =PageFactory.initElements(driver,SampleTestWithPomFindBys.class);
		
		s.ele1.sendKeys("admin");
       s. ele2.sendKeys("admin");

       // driver.navigate().refresh();

       s.ele3.click();
        
	}
	
}