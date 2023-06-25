package org.sikuliprogram;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.sikuli.script.Screen;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;

public class SaravananProgram {
public static void main(String[] args) throws InterruptedException, FindFailed {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\vaishnavi_h\\eclipse-workspace\\InterviewPrograms\\Driver\\chromedriver.exe");
	ChromeOptions ch = new ChromeOptions();
	ch.addArguments("--disable-notifications");
	WebDriver driver = new ChromeDriver(ch);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://qa.fidsafe.com/#/signIn");
	driver.navigate().to("https://qa.fidsafe.com/#/signIn");
	driver.manage().window().maximize();
	//Login
	driver.findElement(By.id("SignIn-email")).sendKeys("a751508@fmr.com");
	driver.findElement(By.id("SignIn-password")).sendKeys("Fidsafe@123");
	
	driver.findElement(By.id("SignIn-ProceedClick")).click();
	//security question
	driver.findElement(By.id("signinSecQuestion")).sendKeys("12345");
	//submit
	driver.findElement(By.id("sign-qs-proceedLogin")).click();
	
	Thread.sleep(5000);
	
	//Add Item button
	driver.findElement(By.xpath("//button[text()='Add Item']")).click();
	
	
	//upload a file
	
	driver.findElement(By.xpath("//app-content-container//li[2]//a[1]")).click();
	
	driver.findElement(By.xpath("//label[text()='Select a file(s) from your computer']")).click();
	
	
	Pattern FileButton = new Pattern("C:\\Users\\vaishnavi_h\\eclipse-workspace\\InterviewPrograms\\TestData\\FileName.PNG");
	Screen screen = new Screen();
	screen.wait(FileButton,5);
	screen.type(FileButton,"C:\\Users\\vaishnavi_h\\eclipse-workspace\\InterviewPrograms\\TestData\\Demo.txt");
	Pattern Open = new Pattern("C:\\Users\\vaishnavi_h\\eclipse-workspace\\InterviewPrograms\\TestData\\Open.PNG");
	screen.wait(Open,5);
	screen.click(Open);
	Thread.sleep(5000);
	driver.close();
	
	
	
	
	
	
	
	
}
}
