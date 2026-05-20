package practice.test;
/**
 * Test class for Contact module
 * @author shast
 */
/**
 * 
 */

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class SearchContactTest extends BaseClass{
  /*
   * 
   * Scenario: login()==> navigate to contact==> create contact==>verify
   */
	@Test
	public void searchContactTest() {
	
		/*Login to app */
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToapp("url", "username", "pas");
	}
}
