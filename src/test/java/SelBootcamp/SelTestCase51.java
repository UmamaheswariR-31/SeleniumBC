package SelBootcamp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelTestCase51 {

	public static void main(String[] args) throws InterruptedException {
		/*Test Steps:
1. Login to https://login.salesforce.com
2. Click on the toggle menu button from the left corner
3. Click View All and click Work Type Groups from App Launcher
4. Click on the Work Type Group tab 
5. Search the Work Type Group 'Salesforce Automation by Your Name'
6. Click on the Dropdown icon and Select Delete
7.Click on the Delete option in the displayed popup window.
8. Verify Whether Work Type group is Deleted using Work Type Group Name
Expected Result:
The Work Type Group is deleted Successfully 
Step Video:
https://drive.google.com/file/d/1Zz67aCHuWNj5CWTiMdbpBvVsEZIbqC1y/view?usp=sharing

Activity
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
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//driver.findElement(By.xpath("//p[text()='Work Type Groups']")).click();
				driver.findElement(By.xpath("//h2[text()='App Launcher']/following::input")).sendKeys("Work Type Groups");
				driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();

				WebDriverWait wait =new WebDriverWait(driver,30);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Work Type Groups']/following::input)[1]")));
				driver.findElement(By.xpath("(//span[text()='Work Type Groups']/following::input)[1]")).sendKeys("Salesforce Automation by Uma R");
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Show Actions']/ancestor::a")));
				Thread.sleep(5000);
				driver.findElement(By.xpath("//span[text()='Show Actions']/ancestor::a")).click();
				driver.findElement(By.xpath("//a[@title='Delete']")).click();
				
			    driver.findElement(By.xpath("//span[text()='Delete']")).click();
			    
			    String popUp = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
			    System.out.println(popUp);

	}

}
