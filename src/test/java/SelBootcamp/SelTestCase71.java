package SelBootcamp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SelTestCase71 {

	public static void main(String[] args) throws InterruptedException {
		/*Test Steps:
1. Launch Salesforce application https://login.salesforce.com/
2. Login with username as "makaia@testleaf.com" and password as "India@123"
3. Click on Learn More link in Mobile Publisher
4. Navigate to the Salesforce Customer Service
5. Mouse hover on Support & Services
6. Click on Ceritifications link
7. Navigate to Certifications window
8. Select Salesforce Architect
9. Click on More Details link for Technical Architect Certification
10. Navigate to Architect Review Board window
11. Verify Location and Dates for Review Board Exam Schedule for next month with only status as Planning as unique
Expected Result:
Each schedule should have unique location
Step Video:
https://drive.google.com/file/d/1kftOqQvOUdzJq_Qw_iHlcAC7UySAGb6m/view?usp=sharing

Activity
Show:

All

Comments

History

Work log

Newest first
*/
		
System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		
		
		// Disable Notification
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver=new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to("https://login.salesforce.com");
		driver.manage().deleteAllCookies();
		
		driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("BootcampSel@123");
		
        driver.findElement(By.id("Login")).click();
        
        driver.findElement(By.xpath("//span[text()='Learn More']")).click();
        Thread.sleep(5000);
        String title = driver.getTitle();
        System.out.println(title);

	}

}
