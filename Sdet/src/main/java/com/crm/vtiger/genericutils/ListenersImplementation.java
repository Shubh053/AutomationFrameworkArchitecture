package com.crm.vtiger.genericutils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener{
	ExtentReports reports;
	ExtentTest test;

	public void onFinish(ITestContext arg0) {
		reports.flush();
	}

	public void onStart(ITestContext arg0) {
		ExtentHtmlReporter reporter; // Path of report and we can make change to look and feel of reports
		reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ "/ExtentReportSDET/ExtentReport.html");
		reporter.config().setDocumentTitle("SDET21");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("Regression");
		
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		
		reports.setSystemInfo("AppURl", "http://localhost:8888");
		reports.setSystemInfo("Platform", "Windows");
		reports.setSystemInfo("Env", "Pre-Prod");
		reports.setSystemInfo("BuildNo", "2.1");
		reports.setSystemInfo("Browser version", "Chrome-93");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		test.log(Status.FAIL, arg0.getThrowable());
		test.log(Status.FAIL, arg0.getMethod().getMethodName() + " is FAILED");
		SuperClass bc = new SuperClass();
		try {
			String path = bc.getscreenshot(arg0.getName());
			test.addScreenCaptureFromPath(path);
			//bc.getscreenshot(arg0.getMethod().getMethodName());
		} catch(Throwable e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult arg0) {
		test.log(Status.SKIP, arg0.getMethod().getMethodName() + " is SKIPPED");
	}

	public void onTestStart(ITestResult arg0) {
		test = reports.createTest(arg0.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult arg0) {
		test.log(Status.PASS, arg0.getMethod().getMethodName() + " is PASSED");
	}

}
