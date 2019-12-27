package com.mercury.tours;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Mercury_Sign_On_Read_Properties {
	ChromeDriver driver ;
	File file=new File("C:\\selenium Traning\\WorkSpace\\Mercury_Tours_Maven\\Mercury_tools.properties");
	Properties prop=new Properties();
	
	
	
  @Test
  public void Sign_On() throws InterruptedException {
	  driver.findElement(By.linkText(prop.getProperty("lsignon"))).click();
		driver.findElement(By.name(prop.getProperty("Iusername"))).sendKeys("testing");
		// driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElementByName(prop.getProperty("Iuserpass")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		Thread.sleep(4000);
	// To select dropdown	
		Select selectpass=new Select(driver.findElementByName("passCount"));
		selectpass.selectByValue("3");
		
		Select dpplace=new Select(driver.findElementByName("fromPort"));
		dpplace.selectByVisibleText("London");
		Thread.sleep(6000);
		
		Select sltair=new Select(driver.findElementByName("airline"));
		sltair.selectByVisibleText("Blue Skies Airlines");
		
		driver.findElementByName("findFlights").click();
	 String dpt= driver.findElementByXPath("//td[@class='title']//font[contains(text(),'DEPART')]").getText();
	 System.out.println(dpt);
  }
  @BeforeTest
  public void LaunchBrowser() throws IOException {
	  String absolutepath=System.getProperty("user.dir");
	  FileInputStream fileInput=new FileInputStream(file);
		prop.load(fileInput);
		//String filepath=absolutepath+"\\chromedriver.exe";
		String filepath=absolutepath+".\\Drivers"+"\\chromedriver.exe";
		System.setProperty("Webdriver.chrome.driver",filepath);
		//System.setProperty("Webdriver.chrome.driver","C:\\selenium Traning\\WorkSpace\\Mercury_Tours\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));
	  
  }

  @AfterTest
  public void CloseBrowser() {
driver.quit();
  }

}

