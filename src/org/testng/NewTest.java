package org.testng;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTest {
	public String baseUrl = "https://dev.symphony4sap.com/home";
	String driverPath = "C:\\Users\\vaishnavi_h\\eclipse-workspace\\InterviewPrograms\\Driver\\chromedriver.exe";
	public WebDriver driver;
	
  @BeforeMethod
  public void beforeMethod() { // launch the browser
	System.out.println("Launch the Chrome Browser");
	System.setProperty("webdriver.chrome.driver", driverPath);
	driver = new ChromeDriver();
	driver.get(baseUrl);
  }
  
  @Test
  public void f() throws InterruptedException {
	  String jobId="test5566";
	  
	  driver.findElement(By.xpath("//button[text()='Go to console']")).click();
	  Thread.sleep(3000);
	  Set<String> windowHandles = driver.getWindowHandles();
	  System.out.println(windowHandles);
	  driver.switchTo().window("https://dev.symphony4sap.com/login");
	  System.out.println( driver.getCurrentUrl());
	  Thread.sleep(3000);
	  
	//  driver.findElement(By.id("customer_code")).click();
	  driver.findElement(By.id("customer_code")).sendKeys("c100001");
	  driver.findElement(By.id("user_name")).sendKeys("testdev");
	  driver.findElement(By.id("password")).sendKeys("Test@123");
	  driver.findElement(By.xpath("//button[text()='LOGIN']")).click();
	  
	  String expectedUrl = "https://dev.symphony4sap.com/dashboard";
	  String actualUrl = driver.getCurrentUrl();
	  Assert.assertEquals(actualUrl, expectedUrl);
	  
	  driver.findElement(By.xpath(" //div[@aria-label='Drag & Drop']")).click();
	  driver.findElement(By.xpath("//h3[text()='Template List']")).click();
	  
	  driver.findElement(By.xpath("//input[@name='templateId']))")).click();
	  driver.findElement(By.xpath("//button[@aria-label='View Template']//child::button")).click();
	  driver.findElement(By.xpath("//ul//li[text()='active']")).click();
	  
	  driver.findElement(By.xpath("//button[text()='Execute']")).click();
	  
	  driver.findElement(By.xpath("//span[text()='Execute Job']")).click();
	  
	  driver.findElement(By.xpath("//button[text()='Next']")).click();
	  
	  driver.findElement(By.id("job_title")).sendKeys(jobId);
	  
	  driver.findElement(By.xpath("(//button[text()='Execute'])[2]")).click();
	  
	  WebElement Status = driver.findElement(By.xpath("(//table//tbody//tr[2]//td[text()='" + jobId +"']//preceding-sibling::td)[2]//span[text()='Finished']"));
	  Assert.assertTrue(Status.getText().contentEquals("Finished"));
	 
	  
  
  }

  @AfterMethod
  public void afterMethod() {
	  //close the browser
	  System.out.println("Closing the browser");
	  driver.close();
  }



}
