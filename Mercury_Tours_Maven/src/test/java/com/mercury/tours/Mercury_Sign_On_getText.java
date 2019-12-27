package com.mercury.tours;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Mercury_Sign_On_getText {
	ChromeDriver driver ;
  @Test
  public void Sign_On() throws InterruptedException {
	  driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		// driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElementByName("password").sendKeys("testing");
		driver.findElement(By.name("login")).click();
		Thread.sleep(4000);
		WebElement ele =driver.findElement(By.linkText("SIGN-OFF"));
		String ActValue=ele.getText();
		String ExpValue="SIGN-OFF";
		System.out.println(ActValue);
		Assert.assertEquals(ActValue, ExpValue);
		
		String Expurl="http://newtours.demoaut.com/mercuryreservation.php";
		String Acturl=driver.getCurrentUrl();
		System.out.println(Acturl);
		Assert.assertEquals(Acturl,  Expurl);
		
		String ExpTitle="Find a Flight: Mercury Tours:";
		String ActTitle=driver.getTitle();
		System.out.println(ActTitle);
		Assert.assertEquals(ActTitle,  ExpTitle);
		//ele.click();
		//To verify whether RoundTrip Selected or Not
		String str=driver.findElementByXPath("//input[@value='roundtrip']").getAttribute("checked");
		System.out.println(str);
		if(str.equalsIgnoreCase("true"))
		{
			System.out.println("RoundTrip selected");
		}
		//To SElect radio button
		 WebElement ele1=driver.findElementByXPath("//input[@value='oneway']");
		 ele1.click();
		Assert.assertEquals(ele1.isSelected(), true);
		
		//To select business button by using css selector
		WebElement ele2=driver.findElementByCssSelector("input[value='Business']");
		ele2.click();
		boolean rt=ele2.isSelected();
		System.out.println(rt+" business radio button is selected");
		//Assert.assertEquals(, true);
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

