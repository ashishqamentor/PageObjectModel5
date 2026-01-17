package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dashboard 
{

	WebDriver w;  //null
	
	@FindBy(xpath = "//input[@type='search']")WebElement serchbox;
	@FindBy(xpath ="//button[contains(text(),'ADD TO CART')]" )WebElement addtokartbtn;
	@FindBy(xpath = "//a[contains(text(),'Top')]") WebElement topdeal;
	
	public dashboard(WebDriver w2) //5418926jguy6bf6y
	{
		this.w = w2;
		PageFactory.initElements(w, this);
	}

	public void addtokart(String vegname) throws Exception
	{
		serchbox.sendKeys(vegname);
		Thread.sleep(2000);
		addtokartbtn.click();
		serchbox.clear();

	}
	
	public void topdeal()
	{
		topdeal.click();
	}
	
}
