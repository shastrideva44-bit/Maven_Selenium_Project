package practice.Testng;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReporterTest2 {

	public ExtentReports report;

	@BeforeSuite
	public void configBS() {

		// SPARK REPORT CONFIGURATION
		ExtentSparkReporter spark =
				new ExtentSparkReporter("./AdvanceReport/report.html");

		spark.config().setDocumentTitle("CRM TEST SUITE RESULTS");
		spark.config().setReportName("CRM REPORT");
		spark.config().setTheme(Theme.DARK);

		// CREATE REPORT
		report = new ExtentReports();

		report.attachReporter(spark);

		// ENVIRONMENT INFO
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME");
	}

	@AfterSuite
	public void configAS() {

		report.flush();
	}

	@Test
	public void createContactTest() {

		ExtentTest test = report.createTest("createContactTest");

		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");

		if ("HDFC".equals("HDC")) {

			test.log(Status.PASS, "contact is created");

		} else {

			test.log(Status.FAIL, "contact is not created");
		}
	}

	@Test
	public void createContacWithOrgtTest() {

		ExtentTest test =
				report.createTest("createContacWithOrgtTest");

		WebDriver driver = new ChromeDriver();

		driver.get("http://49.249.29.4:8888");

		TakesScreenshot ts = (TakesScreenshot) driver;

		String filepath =
				ts.getScreenshotAs(OutputType.BASE64);

		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");

		if ("HDFC".equals("HFC")) {

			test.log(Status.PASS, "contact is created");

		} else {

			test.log(Status.FAIL, "contact is not created");

			test.addScreenCaptureFromBase64String(
					filepath,
					"Error Screenshot");
		}

		driver.quit();
	}

	@Test
	public void createContacWithPhoneNumberTest() {

		ExtentTest test =
				report.createTest("createContacWithPhoneNumberTest");

		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");

		if ("HDFC".equals("HDFC")) {

			test.log(Status.PASS, "contact is created");

		} else {

			test.log(Status.FAIL, "contact is not created");
		}
	}
}