package com.mercury.tours;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class CrossBrowserExample extends ApplicationTestData {
	WebDriver driver;
  @Test(dataProvider="Login")
  public void Sign_On( String uname,String password) throws InterruptedException {
	  driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys(uname);
		// driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		Thread.sleep(6000);
		driver.findElement(By.linkText("SIGN-OFF")).click();
  }
  @BeforeTest
  @Parameters("browser")
  public void setup(String browser) {
	  if(browser.equalsIgnoreCase("Firefox")){
		  String absolutepath=System.getProperty("user.dir");
			//String filepath=absolutepath+"\\chromedriver.exe";
			String filepath=absolutepath+".\\Drivers"+"\\geckodriver.exe";
			System.setProperty("Webdriver.gecko.driver",filepath);
			//System.setProperty("Webdriver.chrome.driver","C:\\selenium Traning\\WorkSpace\\Mercury_Tours\\chromedriver.exe");
			 driver=new FirefoxDriver();
			
	  }
	  else if(browser.equalsIgnoreCase("chrome")){
		  String absolutepath=System.getProperty("user.dir");
			//String filepath=absolutepath+"\\chromedriver.exe";
			String filepath=absolutepath+".\\Drivers"+"\\chrome.exe";
			System.setProperty("Webdriver.chrome.driver",filepath);
			//System.setProperty("Webdriver.chrome.driver","C:\\selenium Traning\\WorkSpace\\Mercury_Tours\\chromedriver.exe");
			 driver=new ChromeDriver();
  }
	  driver.get("http://newtours.demoaut.com/");
  }
  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
