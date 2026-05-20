package practice.Testng;

import org.testng.annotations.Test;

public class ContactTestByPRIORITY {
	@Test (priority = -100)
	public void createContactTest() {
		System.out.println("execute createConatact");
	}
	@Test  (priority = 2)
	public void modifycreatteContactTest() {
		System.out.println("execute modifyConatact");
	}
  
	@Test   (priority = 3)
	public void deleteContactTest() {
		System.out.println("execute deleteContactTest");
	}
}
