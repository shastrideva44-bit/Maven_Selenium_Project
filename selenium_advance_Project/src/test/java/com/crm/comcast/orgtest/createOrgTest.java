package com.crm.comcast.orgtest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.crm.generic.baseutility.BaseClass;

public class createOrgTest extends BaseClass {

	public class CreateContactTest {

		@Test
		public void CreateContactTest() {
			System.out.println("execute CreateOrgTest and verify");
		}

		@Test
		public void CreateContactWithTest() {
			System.out.println("execute CreateOrgWithIndustries and verify");
		}
	}
}