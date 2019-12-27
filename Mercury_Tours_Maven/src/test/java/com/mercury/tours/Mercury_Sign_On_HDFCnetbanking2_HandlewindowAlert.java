package com.mercury.tours;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Mercury_Sign_On_HDFCnetbanking2_HandlewindowAlert {
	ChromeDriver driver ;
  @Test
  public void Sign_On() {
	  driver.switchTo().frame("login_page");
	
	  driver.findElementByXPath("//img[@alt='continue']").click();
	  String actTest=driver.switchTo().alert().getText();
	  String ExpTest= "Customer ID  cannot be left blank.";
	  Assert.assertEquals(actTest, ExpTest);
	  driver.switchTo().alert().accept();
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
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
	  
  }

  @AfterTest
  public void CloseBrowser() {
driver.quit();
  }

}

