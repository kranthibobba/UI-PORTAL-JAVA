package com.MS.Portal;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CustomerFilters extends Users {

/*Scenario covers the following flow:
 * User navigates to the User page
 * Selects filter option from drop down menu
 * Pass the input parameter
 * validates the Row and Column values
 */
 
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://ec2-54-174-213-136.compute-1.amazonaws.com:8080/admin/users");
		driver.manage().window().maximize();
		Select username = new Select (driver.findElement(By.xpath(".//*[@id='q_username_input']/select")));
		username.selectByIndex(0);
		driver.findElement(By.xpath(".//*[@id='q_username']")).sendKeys("testkk");
	    driver.findElement(By.xpath(".//*[@id='new_q']/div[4]/input[1]")).click();
	    
	    WebElement table = driver.findElement(By.xpath("//table[@class='index_table index']"));
		List<WebElement> row = table.findElements(By.xpath("//table[@id='index_table_users']/tbody/tr"));
		System.out.println("Total Number of Rows = " + row.size());
		
		List<WebElement> column = table.findElements(By.tagName("th"));
		System.out.println("Total Number of Column = " + column.size());
		
		for (int i=0;i<=row.size()-1 ;i++){
			System.out.println(row.get(i).getText());
		}
						
		List<WebElement> firstcol = driver.findElements(By.xpath("//table[@id='index_table_users']/tbody/tr/td[3]"));
		for (int j=0; j<row.size();j++){
			System.out.println(firstcol.get(j).getText());
		}
       driver.close();	
	}

}
