package com.mercury.tours;


import java.io.File;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class Mercury_Sign_On_ExtentReports {
	//builds a new report using html template
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	//helps to generate the logs in the test
	ExtentTest test;
	ChromeDriver driver ;
	File file=new File("C:\\selenium Traning\\WorkSpace\\Mercury_Tours_Maven\\Mercury_tools.properties");
	Properties prop=new Properties();
  @Test(priority=2)
  public void Sign_On() throws InterruptedException {
		driver.get("http://newtours.demoaut.com/");
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		// driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElementByName("password").sendKeys("testing");
		driver.findElement(By.name("logins")).click();
		Thread.sleep(4000);
		WebElement ele =driver.findElement(By.linkText("SIGN-OFF"));
		
  }
  @Test(priority=1)
  public void LaunchBrowser() {
	  test=extent.createTest("TestCase1","Launch the chrome and navigate to chrome driver");
	  String absolutepath=System.getProperty("user.dir");
		//String filepath=absolutepath+"\\chromedriver.exe";
		String filepath=absolutepath+".\\Drivers"+"\\chromedriver.exe";
		System.setProperty("Webdriver.chrome.driver",filepath);
		//System.setProperty("Webdriver.chrome.driver","C:\\selenium Traning\\WorkSpace\\Mercury_Tours\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
	
	  
  }
  @BeforeTest()
  public void Startreport(){
	  //initialize the HtmlReporter
	htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/testReport.html"); 
	
	//initialize the ExtentReports and attach the HTml Report
	extent =new ExtentReports();
	extent.attachReporter(htmlReporter);
	
	// to add the sysytem or enivornment info by using the setsystemInfo method
	extent.setSystemInfo("os", "Windows 10");
	extent.setSystemInfo("Browser", "chrome 79");
	
	//configuration items to change the look and feel
	//add content,manage tests etc
	htmlReporter.config().setDocumentTitle("Extent Report Demo");
	htmlReporter.config().setReportName("Test Report");
	htmlReporter.config().setTheme(Theme.STANDARD);
	htmlReporter.config().setTimeStampFormat("EEEE,MMMM,dd,yyyy,hh:mma('ZZZ')");
  }

  @AfterTest
  public void CloseBrowser() 
  {
driver.quit();
extent.flush();
  }

  @AfterMethod
  public void getResult(ITestResult result){
	  if(result.getStatus()==ITestResult.FAILURE){
		  test.log( Status.FAIL, MarkupHelper.createLabel(result.getName()+"FAILED" ,ExtentColor.INDIGO));
		  test.fail(result.getThrowable());
	  }
	  else if(result.getStatus()==ITestResult.SUCCESS){
		  test.log( Status.PASS, MarkupHelper.createLabel(result.getName()+"PASSED" ,ExtentColor.BROWN));
  }
	  else{
		  test.log( Status.SKIP, MarkupHelper.createLabel(result.getName()+"SKIPPED" ,ExtentColor.RED));
		  test.skip(result.getThrowable()); 

}
  }
}

