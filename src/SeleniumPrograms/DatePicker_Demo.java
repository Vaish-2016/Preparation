package SeleniumPrograms;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class DatePicker_Demo {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(ch);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		driver.findElement(By.xpath("//text[@class='dateText']")).click();
				
		String month="Sep";
		
		String year="2023";
	
		
		while(true) {
			String monthyear=driver.findElement(By.xpath("//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD'][2]")).getText();
			
			String array[]=monthyear.split(" ");
			String mon=array[0];
			String yr=array[1];
			String holidayarray[]=yr.split("\n");
			String yr1=holidayarray[0];
			System.out.println("MonthYear: "+monthyear+"	month " + mon + "	Year "+yr1);
		
			if(month.equalsIgnoreCase(mon) && year.equalsIgnoreCase(yr1))
				break;
			
			else 
				driver.findElement(By.xpath("//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD'][3]")).click();
				
		}
		
	}

}
