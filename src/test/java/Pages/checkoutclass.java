package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class checkoutclass
{

	WebDriver w ;  //null
	
	@FindBy(css = "a[class='cart-icon']")WebElement carticon;
	@FindBy(xpath = "//button[contains(text(),'PROCEED TO CHECKOUT')]")WebElement procced;
	@FindBy(css = ".promoCode")WebElement promo;
	@FindBy(xpath = "//button[contains(text(),'Apply')]")WebElement Apply;
	@FindBy(xpath = "//button[contains(text(),'Place Order')]")WebElement PlaceOrder;
	@FindBy(xpath = "//select") WebElement countrylist;
	@FindBy(css = ".chkAgree")WebElement checkbox;
	@FindBy(xpath = "//button[contains(text(),'Proceed')]")WebElement Proceed;
	
	
	public checkoutclass(WebDriver w2) 
	{
		this.w = w2;
		PageFactory.initElements(w, this);
	}


	public void checkout(String promocode, String country)
	{
		carticon.click();
		procced.click();
		promo.sendKeys(promocode);
		Apply.click();
		PlaceOrder.click();
		
		Select s = new Select(countrylist);
		s.selectByVisibleText(country);
		checkbox.click();
		Proceed.click();
		
	}
	
	
}
