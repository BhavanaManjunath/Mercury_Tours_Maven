package com.mercury.tours;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Mercury_Sign_On_TestNG_Class_DataProvider extends ApplicationTestData{
	ChromeDriver driver ;
  @Test(dataProvider="Login")
  public void Sign_On( String uname,String pwd) {
	  driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys(uname);
		// driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElementByName("password").sendKeys(pwd);
		driver.findElement(By.name("login")).click();
		driver.findElementByLinkText("SIGN-OFF").click();
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

