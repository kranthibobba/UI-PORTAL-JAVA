package com.MS.Portal;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Users {

public static String driverPath = "C:/Users/e0215546/Downloads/chromedriver_win32/";
public static WebDriver driver;
public static WebElement Element;

public void customersignup (String uname, String pwd, String eml){
	        driver.findElement(By.name("user[username]")).sendKeys(uname);
	        driver.findElement(By.name("user[password]")).sendKeys(pwd);
	        driver.findElement(By.name("user[email]")).sendKeys(eml);
	        driver.findElement(By.name("commit")).click();       
}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get ("http://ec2-54-174-213-136.compute-1.amazonaws.com:8080/admin");
		driver.manage().window().maximize();
//Scenario1: Customer navigates to Users page and creates new account by selecting "newuser" option
		driver.findElement(By.xpath("//*[@id='users']")).click();
		String url = driver.getCurrentUrl();
		if (url.equals("http://ec2-54-174-213-136.compute-1.amazonaws.com:8080/admin/users")){
			System.out.println("User is on the Users Page");
			}
		else
		{
			System.out.println("User couldn't navigate successfully on to the page");
			}
		boolean existence = driver.findElement(By.partialLinkText("New User")).isDisplayed();
		try{
		if (existence==true){
			System.out.println("NewUser button is Displayed");
		}
		}
		catch (NoSuchElementException e)
		{
			System.out.println("NewUser button is not Displayed");
		}
		driver.findElement(By.partialLinkText("New User")).click();
		String newUserpage = driver.getCurrentUrl();
		if(newUserpage.equals("http://ec2-54-174-213-136.compute-1.amazonaws.com:8080/admin/users/new")){
			System.out.println("Customer is on the new user registration page");
		}
		else{
			System.out.println("Customer couldn't navigate to the new user registration page");
			}
		Users passvalue = new Users();
		//passvalue.customersignup("testkk","testss","testkk@gmail.com");
		//String message = driver.findElement(By.xpath("//div[@class='flash flash_notice']")).getText();
	    //System.out.println("Displayed msg is:"+message);
	    passvalue.customersignup("","",""); 
	    List<WebElement> errorredmsg = driver.findElements(By.xpath("//p[contains(@class, 'inline-errors')]"));
	    System.out.println(errorredmsg.size());
	    //driver.close();
}
}