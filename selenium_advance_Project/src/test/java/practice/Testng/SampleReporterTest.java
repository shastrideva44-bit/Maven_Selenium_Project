 package practice.Testng;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReporterTest {
	@Test
	public void createContactTest() {
		// SPARK REPORT CONFIG
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM TEST SUITE RESULTS");
		spark.config().setReportName("CRM report");
		spark.config().setTheme(Theme.DARK);
		
		// add Env information and create test
		ExtentReports report = new ExtentReports ();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER","CHROME-100");
	ExtentTest test=	report.createTest("createContactTest");
		test.log(Status.INFO,"login to app");
		test.log(Status.INFO,"Login to app");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact");
		  if ("HDFC".equals("HDFC")) {
			  test.log(Status.PASS,"contact  is created ");
		  }else {
			  test.log(Status.FAIL,"contact  is not created ");
		  }
		  report.flush();
		System.out.println();
	}

}
