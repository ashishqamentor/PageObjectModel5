package TestPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
	}
	
	
	//@Test
	public void topdealfunctinality()
	{
		d.topdeal();
	}
	
}

