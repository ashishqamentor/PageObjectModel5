package Pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage 
{
	public WebDriver w;
	@FindBy(css = "#user-name") WebElement username;
	@FindBy(css = "#password") WebElement password;
	@FindBy(css = "#login-button") WebElement loginbutton;
	
	public loginPage(WebDriver w2)
	{
		this.w=w2;
		PageFactory.initElements(w, this);
	}

	public String loginTest(String user, String pass) throws Exception
	{
		username.sendKeys(user);
		password.sendKeys(pass);
		loginbutton.click();
		Thread.sleep(2000);
		
		String actualURl= w.getCurrentUrl();
		return actualURl;
		
		
	}
	
	
}
