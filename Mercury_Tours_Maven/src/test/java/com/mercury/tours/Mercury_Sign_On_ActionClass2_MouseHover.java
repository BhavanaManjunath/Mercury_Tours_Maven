package com.mercury.tours;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Mercury_Sign_On_ActionClass2_MouseHover {
	ChromeDriver driver ;
  @Test
  public void Sign_On_MouseOver() {
	  WebElement element= driver.findElementByXPath("//a[contains(text(),'My Account')]");
	  Actions action=new Actions(driver);
	  action.moveToElement(element).build().perform();
	  driver.findElementById("signInBtn").click();
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
		driver.get("https://www.yatra.com/");
	  
  }

  @AfterTest
  public void CloseBrowser() {
driver.quit();
  }

}

