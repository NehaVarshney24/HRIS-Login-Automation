package com.qait.HRIS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	public void Logout() {
		
		driver.findElement(By.className("profile-btn")).click();
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("fa"))));
		driver.findElement(By.className("fa-sign-out")).click();
	}
	
}
