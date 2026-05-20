package practice.test;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.comcast.crm.basetest.BaseClass;

import junit.framework.Assert;
@Listeners(com.comcast.crm.listenerUtility.ListionerImpClass.class)
public class InvoiceTest extends BaseClass {

    @Test
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

    @Test
    public void createInvoiceWithContactTest() {
        System.out.println("execute createInvoiceTest");
        System.out.println("step-1");
        System.out.println("step-2");
        System.out.println("step-3");
        System.out.println("step-4");
    }
}