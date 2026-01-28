package TestPackage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.google.common.io.Files;

public class listen extends Baseclass implements ITestListener
{
	// listen tracks testing events --> test pass , test fail , test skip , test success 
	ExtentReports extent =extentreportObj();
	ExtentTest test ;
	
	ThreadLocal<ExtentTest> thread = new ThreadLocal<>();
	
	@Override
	public void onTestStart(ITestResult result) 
	{
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		System.out.println("test started");
		String testname = result.getMethod().getMethodName();
		test = extent.createTest(testname);
		thread.set(test);
		thread.get().info("my test is working correctly");
			
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		//screenshot
		System.out.println("test pass");
		
		try {			
			
			w =(WebDriver) result.getTestClass().getRealClass().getField("w").get(result.getInstance());
			
			DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd_MM_YYYY_HH_mm_ss");

	        String dateTime = LocalDateTime.now().format(formatter);
	        String testname = result.getMethod().getMethodName();
			
			TakesScreenshot tc = (TakesScreenshot) w;
			File src = tc.getScreenshotAs(OutputType.FILE);
			File dest = new File("./screenshot/"+testname+"_"+dateTime+".png");
			Files.copy(src, dest);
			
			//added to attach screenshot.
			thread.get().addScreenCaptureFromPath(dest.getAbsolutePath());
			
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		thread.get().pass("test pass successfuuly");
		extent.flush();
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		// screenshot
		System.out.println("test fail");
		
		try {			
			
			w =(WebDriver) result.getTestClass().getRealClass().getField("w").get(result.getInstance());
			
			DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd_MM_YYYY_HH_mm_ss");

	        String dateTime = LocalDateTime.now().format(formatter);
	        String testname = result.getMethod().getMethodName();
			
			TakesScreenshot tc = (TakesScreenshot) w;
			File src = tc.getScreenshotAs(OutputType.FILE);
			File dest = new File("./screenshot/"+testname+"_"+dateTime+".png");
			Files.copy(src, dest);
			
			//added to attach screenshot.
			thread.get().addScreenCaptureFromPath(dest.getAbsolutePath());
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread.get().fail("test fail successfuuly");
		extent.flush();
		
		
		
		
		
	}
	
	
	

}
