package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcat.crm.generic.webdriver.WebDriverUtility;

//RULR 1: create a seperate JAVA CLASS
public class LoginPage extends WebDriverUtility {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		  PageFactory.initElements(driver, this);
	}
	// RULR 2: OBJECT creation or IDENTFYING the web element by @findBy
	 @FindBy(name= "user_name")
	private WebElement usernameEdt;
	 
	 @FindBy(name= "user_password")
	 private WebElement passwordEdt;
	 
	 @FindBy(id= "submitButton")
	 private WebElement loginBtn; 
	  
	//  RULE 3: Provide object INITIALIZATION in test script
	 
	 // RULE 4: object ENCAPSULATION

	 public WebElement getUsernameEdt() {
		 return usernameEdt;
	 }

	 public WebElement getPasswordEdt() {
		 return passwordEdt;
	 }

	 public WebElement getLoginEdt() {
		 return loginBtn;
	 }
	 //  RULE 5 : Provide ACTION: we r doing Object Utilization
	  public void loginToapp(String url, String username, String password) {
		  waitForPageToLoad(driver);
		 driver.get(url);
		  driver.manage().window().maximize();
		  usernameEdt.sendKeys(username);
		  passwordEdt.sendKeys(password);
		  loginBtn.click();
	  }
	 
	 
	

}
