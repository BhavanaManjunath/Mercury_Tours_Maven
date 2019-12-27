package com.mercury.tours;


import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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



public class Mercury_Sign_On_uploadfile {
	ChromeDriver driver ;
  @Test
  public void upload() throws InterruptedException {
	  String absolutepath=System.getProperty("user.dir");
	  String filepath=absolutepath+"\\image\\Devops.jpg";
	  System.out.println(filepath);
	  driver.findElement(By.id("btnChooseFiles")).click();
	  uploadFile (filepath);
	  Thread.sleep(10);
		
  }
  public static void uploadFile(String filelocation){
	  try{
		  //upload file through robot api
		  StringSelection ss=new  StringSelection(filelocation);
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		  //native key strokes forCTRl,V and Enter
		  Robot r =new Robot();
		  r.delay(1000);
		  
		  //press Ctrl+v
		  r.keyPress(KeyEvent.VK_CONTROL);
		  r.keyPress(KeyEvent.VK_V);
		// release Ctrl+V
		  r.keyRelease(KeyEvent.VK_CONTROL);
		  r.keyRelease(KeyEvent.VK_V);
		  
		  r.delay(1000);
		  r.keyPress(KeyEvent.VK_ENTER);
		  r.keyRelease(KeyEvent.VK_ENTER);
		  r.delay(1000);
	  }
	  catch(Exception exp){
		  exp.printStackTrace();
	  }
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
		driver.get("https://gofile.io/?t=uploadFiles");
	  
  }
  @AfterMethod
  public void teardown(){
	  
	  }
	  
  
  

  @AfterTest
  public void CloseBrowser() {
driver.quit();
  }

}

