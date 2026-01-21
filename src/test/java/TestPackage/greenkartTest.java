package TestPackage;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class greenkartTest extends Baseclass 
{
	@Parameters({"url","promo","country"})
	@Test
	public void checkoutTest(String url, String promo, String country) throws Exception
	{
		openUrl(url);
		String veglist = excelDataRead();  // veglist = brocoli,brinjal,tomoato,
		String veg[] =veglist.split(",");  // veg ={brocoli , brinjal, tomato}
		for(String vegname :veg)
		{
			d.addtokart(vegname);
		}
		c.checkout(promo,country);
		assertTrue(false);
	}	
}

