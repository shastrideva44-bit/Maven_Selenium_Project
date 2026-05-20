package practice.Testng;

import org.testng.annotations.Test;

public class CreateContactTest {
	@Test
	public void ContactTest() {
		System.out.println("execute login test");
		System.out.println("navigate To Contact Test");
		System.out.println("execute create contact");
		System.out.println("execute verify contant test");
		System.out.println("execute logout test");
	}

	@Test
	public void navigateToContactTest() {
		System.out.println("execute navigateToContactTest");
	}

	@Test
	public void createContactTest() {
		System.out.println("execute createContactTest");

	}
}
