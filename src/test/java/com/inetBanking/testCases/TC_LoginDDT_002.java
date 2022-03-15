
package com.inetBanking.testCases;
import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginDDT_002  extends BaseClass{
	
	
	
	
	@Test(dataProvider="LoginData")
	public void LoginDDT(String user,String pwd) throws InterruptedException {
		
		
		Thread.sleep(1000);
		LoginPage lp = new LoginPage(driver);
		WebElement frame1 = driver.findElement(By.id("ccpa-consent-notice"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.id("saveAndExit")).click();
		lp.setUserName(username);
		logger.info("user name provided");
		
		
		lp.setPassword(password);
		logger.info("password provided");
		lp.clickSubmit();
		Thread.sleep(5000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
			
		}
	
	}
	
	
	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert().dismiss();
			
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/LoginData.xlsx";
		int rownum =XLUtils.getRowCount(path, "sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i =2;i<rownum;i++)
		{
			for(int j =0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "sheet1",i,j);  //1 0 ,2 1 ,3 2
				
			}
		}
		return logindata;
	}
}
