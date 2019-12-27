package com.mercury.tours;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Mercury_Sign_On_navigatealllinks {
	ChromeDriver driver ;
  @Test
  public void navigateToallLinks() {
	  List<WebElement> linksize=driver.findElements(By.tagName("a"));
	  int linkcount=linksize.size();//it is int so we are converting to string
	  System.out.println("Total no of links available"+ linkcount);
	  String[] links=new String[linkcount];
	  System.out.println("List of links available");
	  //To print all the linnks of the webpage
	   for(int i=0; i<linkcount;i++){
		   links[i]=linksize.get(i).getAttribute("href");
		   System.out.println(linksize.get(i).getAttribute("href"));
		    }
	   
	   //navigate to each link on the webpage
	   for(int i=0; i<linkcount;i++){
		   driver.navigate().to(links[i]);
		   System.out.println(driver.getTitle());
		   driver.navigate().back();
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
		driver.get("https://www.google.co.in/");
	  
  }

  @AfterTest
  public void CloseBrowser() {
driver.quit();
  }

}

