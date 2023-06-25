package org.testng;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FazzyInterview {
	public static void main(String[] args) throws InterruptedException {
		String baseUrl = "https://dev.symphony4sap.com/home";
		String driverPath = "C:\\Users\\vaishnavi_h\\eclipse-workspace\\InterviewPrograms\\Driver\\chromedriver.exe";
		WebDriver driver;
		
		System.out.println("Launch the Chrome Browser");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl);
		
		
		String jobId="test5577";
		  
		  driver.findElement(By.xpath("//button[text()='Go to console']")).click();
		  Thread.sleep(3000);
		  String parentId = driver.getWindowHandle();
		  Set<String> allId = driver.getWindowHandles();
		  System.out.println(allId);
		  for (String x : allId) {
			  if(!parentId.equals(x)) {
				  driver.switchTo().window(x);
			  }			
		}
		  
		  System.out.println( driver.getCurrentUrl());
		  Thread.sleep(3000);
		  
		//  driver.findElement(By.id("customer_code")).click();
		  driver.findElement(By.id("customer_code")).sendKeys("c100001");
		  driver.findElement(By.id("user_name")).sendKeys("testdev");
		  driver.findElement(By.id("password")).sendKeys("Test@123");
		  driver.findElement(By.xpath("//button[text()='LOGIN']")).click();
		  
		  Thread.sleep(4000);
		  String expectedUrl = "https://dev.symphony4sap.com/dashboard";
		  String actualUrl = driver.getCurrentUrl();
		  Assert.assertEquals(actualUrl, expectedUrl);
		  
		  Actions action = new Actions(driver);
		  action.moveToElement(driver.findElement(By.xpath("//div[@aria-label='Drag & Drop']//parent::a"))).build().perform();
		  
		  Thread.sleep(2000);
//	  driver.findElement(By.xpath("//div[@aria-label='Drag & Drop']//parent::a")).click();
		  
		  driver.findElement(By.xpath("//div[text()='Drag & Drop']")).click();
		  Thread.sleep(4000);
		  driver.findElement(By.xpath("//h3[text()='Template List']//parent::div//child::p")).click();
		  Thread.sleep(4000);
		  driver.findElement(By.xpath("//input[@name='templateId']//parent::span")).click();
		  Thread.sleep(4000);
		  driver.findElement(By.xpath("//button[@aria-label='View Template']//child::button")).click();
		  Thread.sleep(4000);
		  driver.findElement(By.xpath("//ul//li[text()='active']")).click();
		  Thread.sleep(10000);
		  driver.findElement(By.xpath("//button[text()='Execute']")).click();
		  Thread.sleep(4000);
		  driver.findElement(By.xpath("//span[text()='Execute Job']")).click();
		  Thread.sleep(4000);
		  driver.findElement(By.xpath("//button[text()='Next']")).click();
		  Thread.sleep(4000);
		  driver.findElement(By.id("job_title")).sendKeys(jobId);
		  Thread.sleep(4000);
		  driver.findElement(By.xpath("(//button[text()='Execute'])[2]")).click();
		  Thread.sleep(4000);
		  WebElement Status = driver.findElement(By.xpath("(//table//tbody//tr[2]//td[text()='" + jobId +"']//preceding-sibling::td)[2]//span[text()='Running']"));
		  Assert.assertTrue(Status.getText().contentEquals("Running"));
		  Thread.sleep(4000);
		  System.out.println("Closing the browser");
		  driver.close();
		
		
	}

}
