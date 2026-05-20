package com.comcast.crm.listenerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

public class ListionerImpClass1 implements ITestListener, ISuiteListener {

	public ExtentSparkReporter spark;

	public static ExtentReports report;

	public static ExtentTest test;

	@Override
	public void onStart(ISuite suite) {

		System.out.println("=== Report Configuration ===");

		String timeStamp =
				new Date().toString()
				.replace(" ", "_")
				.replace(":", "_");

		// SPARK REPORT CONFIG
		spark = new ExtentSparkReporter(
				"./AdvanceReport/report_" + timeStamp + ".html");

		spark.config().setDocumentTitle("CRM TEST SUITE RESULTS");

		spark.config().setReportName("CRM REPORT");

		spark.config().setTheme(Theme.DARK);

		// CREATE REPORT
		report = new ExtentReports();

		report.attachReporter(spark);

		// ENV INFO
		report.setSystemInfo("OS", "Windows-10");

		report.setSystemInfo("BROWSER", "CHROME");
	}

	@Override
	public void onTestStart(ITestResult result) {

		System.out.println(
				"==== "
				+ result.getMethod().getMethodName()
				+ " == START ==");

		test = report.createTest(
				result.getMethod().getMethodName());

		UtilityClassObject.setTest(test);

		test.log(
				Status.INFO,
				result.getMethod().getMethodName()
				+ " === STARTED");
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		System.out.println(
				"==== "
				+ result.getMethod().getMethodName()
				+ " == PASS ==");

		test.log(
				Status.PASS,
				result.getMethod().getMethodName()
				+ " === COMPLETED");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		String testName =
				result.getMethod().getMethodName();

		test.log(
				Status.FAIL,
				testName + " === FAILED");

		String timeStamp =
				new Date().toString()
				.replace(" ", "_")
				.replace(":", "_");

		// TYPE CASTING
		TakesScreenshot ts =
				(TakesScreenshot) BaseClass.sdriver;

		// SCREENSHOT
		String src =
				ts.getScreenshotAs(OutputType.BASE64);

		// ATTACH SCREENSHOT
		test.addScreenCaptureFromBase64String(
				src,
				testName + "_" + timeStamp);
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		test.log(
				Status.SKIP,
				result.getMethod().getMethodName()
				+ " === SKIPPED");
	}

	@Override
	public void onFinish(ISuite suite) {

		System.out.println("=== Report Backup ===");

		report.flush();
	}
}