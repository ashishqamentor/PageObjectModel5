package TestPackage;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class login extends Baseclass 
{

	@Test(dataProvider = "mydata")
	public void login(String user, String pass) throws Exception
	{
		openUrl("https://www.saucedemo.com/");
		String actualURl= l.loginTest(user,pass);
		assertEquals(actualURl, "https://www.saucedemo.com/inventory.html");
	}
	
	@DataProvider(name = "mydata")
	public Object[][] excelDataread() throws Exception
	{
		FileInputStream fis = new FileInputStream("./Data/veglist.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(1);
		int rowcount = sh.getLastRowNum();
		int columcount = sh.getRow(0).getLastCellNum();
		
		Object obj[][] = new Object[rowcount][columcount];
		for(int i= 0;i<rowcount;i++)  //0 , 1
		{
			XSSFRow row = sh.getRow(i+1);   // 2
			for(int j =0;j<columcount;j++) //0 ,1 ,2
			{
				obj[i][j]=row.getCell(j).getStringCellValue();
			}
		}
		return obj;	
	}
}
