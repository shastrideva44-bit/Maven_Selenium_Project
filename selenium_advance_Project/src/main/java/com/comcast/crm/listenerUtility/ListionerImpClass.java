package com.comcast.crm.listenerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;

public class ListionerImpClass implements ITestListener, ISuiteListener {
	 public ExtentSparkReporter spark;
	public static ExtentReports report;
	
    @Override
    public void onTestStart(ITestResult result) {

        System.out.println("==== " + result.getMethod().getMethodName() + " == START ==");
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        System.out.println("==== " + result.getMethod().getMethodName() + " == END ==");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        // Fetch failed test method name
        String testName = result.getMethod().getMethodName();

        // Current date and time
        String timeStamp = new Date().toString().replace(" ", "_").replace(":", "_");

        // Type casting
        TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;

        // Capture screenshot
        File src = ts.getScreenshotAs(OutputType.FILE);

        // Destination path
        String path =
                "E:\\ECLIPSE\\AUTOMATION IN SELENIUM\\selenium_advance_Project\\Screenshot\\"
                        + testName + "_" + timeStamp + ".jpeg";

        File dest = new File(path);

        // Copy screenshot
        try {
            FileHandler.copy(src, dest);

            System.out.println("Screenshot taken successfully");

        } catch (IOException e) {

            e.printStackTrace();
        }
        
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onStart(ISuite suite) {
    	String timeStamp = new Date().toString().replace(" ", "_").replace(":", "_");
        System.out.println("=== Report Configuration ===");
    	// SPARK REPORT CONFIG
        ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_"+timeStamp+".html");
		spark.config().setDocumentTitle("CRM TEST SUITE RESULTS");
		spark.config().setReportName("CRM report");
		spark.config().setTheme(Theme.DARK);

		// add Env information and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");

    }

    @Override
    public void onFinish(ISuite suite) {

        System.out.println("=== Report Backup ===");
        report.flush();
    }
}