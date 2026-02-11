package logincucumber;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import com.google.common.io.Files;

import TestPackage.Baseclass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginStepDefination //extends Baseclass
{

	WebDriver w ;
	
	@Given("user is on login site")
	public void site() throws Exception
	{
		w= new ChromeDriver();
		w.get("https://www.saucedemo.com/");
	}
	
	@When("^User enter (.+) and (.+) and click on login button$")
	public void credentials(String user ,String pass)
	{
		w.findElement(By.xpath("//input[contains(@placeholder ,'Username')]")).sendKeys(user);
		w.findElement(By.cssSelector("#password")).sendKeys(pass);
		w.findElement(By.xpath("//input[contains(@name,'login-button')]")).click();
	}
	
	@Then("login successfull {string}")
	public void dashboard(String expected_URL) throws Exception
	{
		DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd_MM_YYYY_HH_mm_ss");
        String dateTime = LocalDateTime.now().format(formatter);
		
		TakesScreenshot tc = (TakesScreenshot)w;
		File src = tc.getScreenshotAs(OutputType.FILE);
		File dest = new File("./cucumberReport/login_"+dateTime+".png");
		Files.copy(src, dest);
		
		String actual_URL = w.getCurrentUrl();
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actual_URL, expected_URL);
		
		w.quit();
		
		sa.assertAll();
	}
	
	
}
