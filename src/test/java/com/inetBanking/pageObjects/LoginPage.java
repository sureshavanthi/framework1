package com.inetBanking.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {
WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	// @FindBy(xpath="(//input[@name='btnk'])[2]")
	// @CacheLookup
    // WebElement searchbutton ;

	
	@FindBy(xpath = "/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement lnkLogout;
	
	public void setUserName(String uname)
	{
		txtUserName.sendKeys(uname);
	}
	public void setPassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	public void clickSubmit() 
	{
		
		
		btnLogin.click();
//		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
//		executor.executeScript("arguments[0].click();",searchbutton);
	}
	public void clickLogout()
	{
		lnkLogout.click();
	}
	

}
