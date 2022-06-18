package SelBootcamp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelTestcase7 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		// Disable Notification
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
		
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
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Work Type Groups");
		driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
		
		WebDriverWait wait =new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-context-bar__label-action slds-p-left--none slds-p-right--x-small']")));
	
		driver.findElement(By.xpath("//div[@class='slds-context-bar__label-action slds-p-left--none slds-p-right--x-small']")).click();
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[local-name()='svg' and @class='slds-icon slds-icon-text-default slds-icon_xx-small']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='New Work Type Group']")));
		WebElement newButt = driver.findElement(By.xpath("//span[text()='New Work Type Group']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", newButt);
		//driver.findElement(By.xpath("//span[text()='New Work Type Group']")).click();
		
		driver.findElement(By.xpath("//input[@class=' input']")).sendKeys("Salesforce Automation by Uma R 001");
		
		driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral uiButton--brand uiButton forceActionButton']")).click();
		
		String msg = driver.findElement(By.xpath("//span[@class='uiOutputText']")).getText();
		
		System.out.println(msg);

	}

}
