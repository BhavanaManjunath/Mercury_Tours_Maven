package com.mercury.tours;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Mercury_Sign_On_Depart {
	ChromeDriver driver ;
  @Test
  public void Sign_On() throws InterruptedException {
	  driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		// driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElementByName("password").sendKeys("testing");
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

