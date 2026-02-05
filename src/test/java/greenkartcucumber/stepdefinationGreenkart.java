package greenkartcucumber;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;

import TestPackage.Baseclass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepdefinationGreenkart extends Baseclass
{

	@Given("user is on greenkart site.")
	public void user_is_on_greenkart_site() throws Exception 
	{
		openUrl("https://rahulshettyacademy.com/seleniumPractise/#/");
	}

	@When("user add items in basket.")
	public void user_add_items_in_basket() throws Exception
	{
		String veglist = excelDataRead();  // veglist = brocoli,brinjal,tomoato,
		String veg[] =veglist.split(",");  // veg ={brocoli , brinjal, tomato}
		for(String vegname :veg)
		{
			d.addtokart(vegname);
		}
	}
	
	
	@And("user do checkout")
	public void checkout()
	{
		c.checkout("ashish", "India");
	}
	
	@Then("checkout is done and successful message is dispalyed.")
	public void successful() throws Exception
	{
		TakesScreenshot tc = (TakesScreenshot) w;
		File src = tc.getScreenshotAs(OutputType.FILE);
		File dest = new File("./cucumberReport/checkout.png");
		Files.copy(src, dest);
		terminate();
	}
	
}
