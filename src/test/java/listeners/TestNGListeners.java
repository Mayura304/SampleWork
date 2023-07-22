package listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import testcases.BaseTests;

public class TestNGListeners extends BaseTests implements ITestListener {
	
	ExtentReports extent = ExtentReportGen.extentReportGenerator();
	public static ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		
		ITestListener.super.onTestStart(result);
		System.out.println("Test case :"+result.getMethod().getMethodName()+" has been started");
		test = extent.createTest(result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		ITestListener.super.onTestSuccess(result);
		System.out.println("Test case :"+result.getMethod().getMethodName()+" has been success");
		test.log(Status.PASS, "Test case passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
	
		ITestListener.super.onTestFailure(result);
		System.out.println("Test case :"+result.getMethod().getMethodName()+" has been failed");
		test.fail(result.getThrowable());
		try {
				test.addScreenCaptureFromPath(Screenshot.captureScreenshot(driver, result.getMethod().getMethodName()));
		} 
		catch (IOException e)
		{
			System.out.println("Exception arrived catch is executing");
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		ITestListener.super.onTestSkipped(result);
		System.out.println("Test case :"+result.getMethod().getMethodName()+" has been skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		
		ITestListener.super.onStart(context);
		System.out.println("Test tag "+context.getName()+" has been started");		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		ITestListener.super.onFinish(context);
		System.out.println("Test tag "+context.getName()+" has been finished");	
		extent.flush();
	}

}
