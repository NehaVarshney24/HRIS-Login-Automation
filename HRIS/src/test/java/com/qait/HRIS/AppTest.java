package com.qait.HRIS;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class AppTest 
{
    WebDriver driver;
    App hris;
    
    @BeforeClass
    public void before()
    {
    	System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe");
    	driver=new ChromeDriver();
    	driver.get("https://hris.qainfotech.com");
    	hris=new App(driver);
    }
    
    
//    @Test(expectedExceptions=NoSuchElementException.class)
//    public void login()
//    {
//    	hris.loginForm("nehavarshney", "Neha@321#");
//    	Assert.assertFalse(hris.isDisplayed());
//    }
    
    @Test
	 public void Incorrect_password_test() {

		 Assert.assertEquals("Invalid Login", hris.InvalidPassword("nehavarshney", "Neha"));
	 }
	 
	
	 @Test
	 public void Blank_Password_test() {
		 
		 Assert.assertNotEquals(null,hris.BlankPassword("nehavarshney",""));
	 }
	 
	 
   @Test(dependsOnMethods= {"Incorrect_password_test","Blank_Password_test"})
	public void Correct_credientials_test() {
		Assert.assertFalse(hris.ValidCrendentials("nehavarshney","Neha@321#").isloginpage());
	}
}
