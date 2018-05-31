package com.MS.Portal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Users {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://ec2-54-174-213-136.compute-1.amazonaws.com:8080/admin");
		
		driver.close();

	}

}
