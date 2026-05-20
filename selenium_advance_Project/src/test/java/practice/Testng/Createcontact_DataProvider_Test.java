package practice.Testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Createcontact_DataProvider_Test {
	@Test(dataProvider = "getData")
	public void createContactTest (String firstName, String lastName , long phoneNumber) {
		System.out.println("firstName :" +firstName+  ",lastName:" + lastName + ",phoneNumber :" + phoneNumber);
	}

@DataProvider
public Object[][] getData() {
Object[][] objArr = new Object[3][3];
objArr[0][0]= "Devashish";
objArr[0][1]= "Automatiom Engineer";
objArr[0][2]=12345679898l;

objArr[1][0]= "Krishna";
objArr[1][1]= "Friend";
objArr[1][2]=12345677799l;

objArr[2][0]= "Time";
objArr[2][1]= "Guru";
objArr[2][2]=12345667890l;
return objArr;

}
	

}