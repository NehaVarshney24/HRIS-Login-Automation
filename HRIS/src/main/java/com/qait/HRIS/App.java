package com.qait.HRIS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Hello world!
 *
 */
public class App 
{
    WebDriver driver;
    WebElement username;
    public App(WebDriver driver)
    {
    	this.driver=driver;
    }
    
    private WebElement getUsertext() {
		return this.driver.findElement(By.id("txtUserName"));
	}
	
	private WebElement getUserPassword() {
		return this.driver.findElement(By.id("txtPassword"));
	}
	
	
	private void EnterDetails(String username, String password) {
		getUsertext().clear();
		getUsertext().sendKeys(username);
		getUserPassword().clear();
		getUserPassword().sendKeys(password);
		getUsertext().submit();
		
	}
	
	public String InvalidPassword(String username, String password) {
		EnterDetails(username, password);
		return driver.findElement(By.className("loginTxt")).getText();
	}
	
	public String BlankPassword(String username,String password) {
		EnterDetails(username, password);
		return driver.findElement(By.id("txtPassword")).getAttribute("class");
		
	}
	
	public TestTimesheet ValidCrendentials(String username, String password) {
		EnterDetails(username, password);
		return new TestTimesheet(driver);
	}
	
	
	
}
