package com.MS.Portal;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class CustomerFilters extends Users {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://ec2-54-174-213-136.compute-1.amazonaws.com:8080/admin/users");
		driver.manage().window().maximize();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	//driver.close();	
	}

}
