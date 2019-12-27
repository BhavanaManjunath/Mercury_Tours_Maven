package com.mercury.tours;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Mercury_Sign_On_ScreenShot {
	ChromeDriver driver ;
  @Test
  public void Sign_On() throws InterruptedException {
	  driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		// driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElementByName("password").sendKeys("testing");
		driver.findElement(By.name("logins")).click();
		Thread.sleep(4000);
		
  }
  @BeforeTest
  public void LaunchBrowser() {
	  String absolutepath=System.getProperty("user.dir");
		//String filepath=absolutepath+"\\chromedriver.exe";
		String filepath=absolutepath+".\\Drivers"+"\\chromedriver.exe";
		System.setProperty("Webdriver.chrome.driver",filepath);
		//System.setProperty("Webdriver.chrome.driver","C:\\selenium Traning\\WorkSpace\\Mercury_Tours\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");
	  
  }
  @AfterMethod
  public void screenshot(ITestResult result)throws IOException
  {
	  if(ITestResult.FAILURE==result.getStatus())
	  {
		  File BrowserScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//FileUtils.copyFile(BrowserScreenShot,new File("C:\\selenium Traning\\WorkSpace\\Mercury_Tours_Maven\\ScreenShot\\login.png"));
		  String Filepath=System.getProperty("user.dir")+"\\Screenshot";
	 FileUtils.copyFile(BrowserScreenShot,new File(Filepath +"/"+result.getName()+"_"+System.nanoTime()+".png"));
	  
	  }
	  
  }
  

  @AfterTest
  public void CloseBrowser() {
driver.quit();
  }

}

