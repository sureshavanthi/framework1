package com.inetBanking.testCases;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


import com.inetBanking.utilities.ReadConfig;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class BaseClass {
	ReadConfig readconfig = new ReadConfig();

	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getpassword();
	public static WebDriver driver;
	public static Logger logger;
	
	
	@SuppressWarnings("deprecation")
	@Parameters("browser")
	@BeforeMethod
	public void setup(String br)
	{
	
	 logger = Logger.getLogger("ebanking");	   
	PropertyConfigurator.configure("log4j.properties");	
	
		   
	if(br.equals("chrome"))	   
	{
		System.setProperty("webdriver.chrome.driver",readconfig.getchromepath());
	   driver =new ChromeDriver(); 
	} 
	 else if(br.equals("firefox"))   
	 {
		 System.setProperty("webdriver.gecko.driver",readconfig.getfirefoxpath());
		   driver =new FirefoxDriver();  
	 }
	 else if(br.equals("ie"))	
	 {
		 System.setProperty("webdriver.ie.driver",readconfig.getIEpath());
		   driver =new InternetExplorerDriver();  	 
	 }
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get(baseURL);
    }
	
	@AfterMethod
	public void tearDown()
	{
	//	driver.quit();
	}		
		public void captureScreen(WebDriver driver, String tname) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
			FileUtils.copyFile(source, target);
			System.out.println("Screenshot taken");
		}
		public String randomestring()
		{
			String generatedstring = RandomStringUtils.randomAlphabetic(8);
			return (generatedstring);
			
		}
		public static String randomeNum()
		{
			String generatedstring2 = RandomStringUtils.randomAlphabetic(4);
			return(generatedstring2);
		}
		
	}
