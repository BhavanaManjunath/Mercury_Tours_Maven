package com.mercury.tours;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Mercury_Sign_On_HDFCnetbanking {
	ChromeDriver driver ;
  @Test
  public void Sign_On() {
	  driver.switchTo().frame("login_page");
	 WebElement ele= driver.findElementByXPath("//input[@name='fldLoginUserId']");
	  ele.sendKeys("1000");
	  driver.findElementByXPath("//img[@alt='continue']").click();
	  driver.switchTo().defaultContent();
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

