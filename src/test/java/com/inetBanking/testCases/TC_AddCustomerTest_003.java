
package com.inetBanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{
	

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		Thread.sleep(4000);
		
		WebElement frame1 = driver.findElement(By.id("ccpa-consent-notice"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.id("saveAndExit")).click();
		
		lp.clickSubmit();
		logger.info("clicked on submit");
		Thread.sleep(6000);
	//  WebElement NCframe = driver.findElement(By.xpath("//*[@id='ad_iframe']"));
	//	driver.switchTo().frame(NCframe);
	//	driver.findElement(By.xpath("//span[text()='Close')")).click();
	//	driver.switchTo().defaultContent();
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("providing customer details....");
		
		
		addcust.custName("Pranav");
		addcust.custgender("male");
		addcust.custdodb("05","27","2007");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("GUNTUR");
		addcust.custstate("AP");
		addcust.custpinno("522006");
		addcust.custtelephoneno("987890091");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
			
	}


}