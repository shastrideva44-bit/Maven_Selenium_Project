package practice.test;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.comcast.crm.basetest.BaseClass;

import junit.framework.Assert;

public class InvoiceTest2 extends BaseClass {

    @Test(retryAnalyzer= com.comcast.crm.listenerUtility.RetryListenerImp.class)
    public void createInvoiceTest() {
        System.out.println("execute createInvoiceTest");
    //String var =   driver.getTitle();
        String actTitle = driver.getTitle();
        Assert.assertEquals(actTitle, "Login");
    System.out.println("step-1");
    System.out.println("step-2");
    System.out.println("step-3");
    System.out.println("step-4");
    }

   
}