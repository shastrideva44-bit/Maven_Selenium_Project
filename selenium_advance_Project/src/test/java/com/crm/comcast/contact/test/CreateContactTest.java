package com.crm.comcast.contact.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.crm.generic.baseutility.BaseClass;

public class CreateContactTest   {
	
	@BeforeSuite
	public void configBS() {
		System.out.println("execute BS");
	}
	@BeforeClass
	public void configBC() {
		System.out.println("execute BC");
	}
	
	@BeforeMethod
	public void configBM() {
		System.out.println("execute BM");
	}
	
	@Test
	public void CreateContactTest () {
	System.out.println("execute CreateContactTest");
	}
	
	@Test
	public void CreateContactWithTest () {
	System.out.println("execute CreateContactWithTest");
	}


	@AfterMethod
	public void configAM() {
		System.out.println("execute AM");
	}
	@AfterClass
	public void configAC() {
		System.out.println("execute AC");
	}
	
	@AfterSuite
	public void configAS() {
		System.out.println("execute AS");
	}
}
