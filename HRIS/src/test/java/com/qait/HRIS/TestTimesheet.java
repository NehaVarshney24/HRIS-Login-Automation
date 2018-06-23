package com.qait.HRIS;

import org.openqa.selenium.WebDriver;

public class TestTimesheet {

	WebDriver driver;
	
	public TestTimesheet(WebDriver driver) {
		this.driver=driver;
	}
	
	public boolean isloginpage() {
		return this.driver.getCurrentUrl().equals("https://hris.qainfotech.com/login.php");
	}
	
}
