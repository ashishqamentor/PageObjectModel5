package TestPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Pages.checkoutclass;
import Pages.dashboard;

public class Baseclass 
{
	public WebDriver w ;
	public dashboard d;
	public checkoutclass c;
	
	@BeforeTest
	public void launch() throws Exception
	{
		FileInputStream fis = new FileInputStream("./Data/config.properties");
		Properties p = new Properties();
		p.load(fis);
		String browser = p.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			ChromeOptions op = new ChromeOptions();
			op.addArguments("--incognito");
			w = new ChromeDriver(op);
			
		}
		
		if(browser.equalsIgnoreCase("MicrosoftEdge"))
		{
			EdgeOptions op = new EdgeOptions();
			op.addArguments("inprivate");
			w = new EdgeDriver(op);
			
		}
		
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		w.manage().deleteAllCookies();
		w.manage().window().maximize();
		
		d = new dashboard(w);
		c = new checkoutclass(w);
	}

	
	public String excelDataRead() throws Exception
	{
		FileInputStream fis = new FileInputStream("./Data/veglist.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(0);
		int rowcount = sh.getLastRowNum();
		String veglist ="";
		for(int i = 0;i<rowcount;i++)
		{
			XSSFRow row =sh.getRow(i+1);
			XSSFCell vegcell = row.getCell(0);
			veglist = veglist + vegcell.getStringCellValue()+"," ; // veglist = broco, 
															// veglist =  broco, brinjal ,
					
		}
		
		return veglist;	 
	}
	
 	public void openUrl(String url) throws Exception
	{ 
		w.get(url);
	}
	
	
 	@AfterTest
	public void terminate()
	{
		w.quit();
	}
	
	
	
	
	
}
