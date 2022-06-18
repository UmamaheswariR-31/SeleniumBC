package SelBootcamp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelTestCase50 {

	public static void main(String[] args) throws InterruptedException {
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
				/*WebElement dd = driver.findElement(By.xpath("//span[text()='Show Actions']/ancestor::a"));
				
				try {
					Actions action2 =new Actions(driver);
					action2.moveToElement(dd).build().perform();
					dd.click();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				Actions action2 =new Actions(driver);
				action2.moveToElement(dd).click().sendKeys(dd, "Edit").build().perform();*/
				driver.findElement(By.xpath("//a[@title='Edit']")).click();
				
				WebElement des = driver.findElement(By.xpath("//span[text()='Description']/following::textarea"));
				des.clear();
				des.sendKeys("Automation");
				
				driver.findElement(By.xpath("//span[@class='label inputLabel uiPicklistLabel-left form-element__label uiPicklistLabel']/following::a")).click();
				
				WebElement capacity = driver.findElement(By.xpath("//a[text()='Capacity']"));
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", capacity);
				
				driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("(//a[text()='Salesforce Automation by Uma R'])[1]")).click();
				String descr = driver.findElement(By.xpath("//span[@class='uiOutputTextArea']")).getText();
				System.out.println(descr);
	}

}
