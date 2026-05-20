package practice.Testng;

import org.testng.annotations.Test;

public class OrderTestByInvocationCount {
	
	@Test(invocationCount = 10)
	public void createOrderTest() {
		System.out.println("execute createOrderTest==123");
	             
			}

	@Test(enabled = false)     // this is not participate in the execution so THIRD test case will not execute whether we r giving 'dependsOnMethods' in next test case
	public void billinganOrderTest() {
		System.out.println("execute billinganOrderTest==123");
	}

	@Test (dependsOnMethods =  "billinganOrderTest")
	public void deleteanOrderTest() {
		System.out.println("execute deleteanOrderTest==123");
	}
}
