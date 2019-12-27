package com.mercury.tours;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Mercury_Sign_On_Xpath_Followingsiling {
	ChromeDriver driver ;
  @Test
  public void Sign_On() throws InterruptedException {
	  //following-sibling
	  driver.findElementByXPath("//td[@width='67']//following-sibling::td[2]/a").click();
	  Thread.sleep(4000);
	  //preceding sibling
	  driver.findElementByXPath("//td[@width='74']//preceding-sibling::td[2]/a").click();
	  
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

  @AfterTest
  public void CloseBrowser() {
driver.quit();
  }

}

