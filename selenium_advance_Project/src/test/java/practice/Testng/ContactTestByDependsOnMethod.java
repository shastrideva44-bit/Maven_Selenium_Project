package practice.Testng;

import org.testng.annotations.Test;

public class ContactTestByDependsOnMethod {
	
	@Test 
	public void createContactTest() {
		System.out.println("execute createConatact with ==HDFC");
	}
	@Test  (dependsOnMethods = "createContactTest")
	public void modifycreatteContactTest() {
		System.out.println("execute modifyConatact ==HDFC TO ICICI");
	}
  
	@Test   (dependsOnMethods = "modifycreatteContactTest")
	public void deleteContactTest() {
		System.out.println("execute deleteContactTest ICICI");
	}
}
