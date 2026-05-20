package practice.Testng;

import org.testng.annotations.Test;

public class OrderTest {
	@Test
	public void createOrderTest() {
		System.out.println("execute createOrderTest==123");
		String str = null;                  //it will give NULL POINTER EXCEPTION
		System.out.println(str.equals("123"));
	}

	@Test(dependsOnMethods = "createOrderTest")
	public void billinganOrderTest() {
		System.out.println("execute billinganOrderTest==123");
	}

}
