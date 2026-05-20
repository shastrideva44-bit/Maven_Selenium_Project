package com.Devashish_Automation_Project.Selenium_advance_Project;

import java.util.Random;

public class GenerateRandomNumberTest {

	public static void main(String[] args) {
		Random random = new Random();
		int randomInt = random.nextInt(100);
		System.out.println(randomInt);

	}

}
