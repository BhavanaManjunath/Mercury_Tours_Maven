package com.mercury.tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mercury_Sign_On_ActionClass_DragAndDrop {
	ChromeDriver driver;

	@Test
	public void Sign_On_DragAndDrop() throws InterruptedException {

		Actions action = new Actions(driver);
		// Find to element which need to drag
		WebElement drag = driver.findElementById("draggable");
		// find element which we need to drop
		WebElement drop = driver.findElementById("droppable");
		// this will drag element to destination
		action.dragAndDrop(drag, drop).build().perform();
		Thread.sleep(4000);
	}

	@BeforeTest
	public void LaunchBrowser() {
		String absolutepath = System.getProperty("user.dir");
		// String filepath=absolutepath+"\\chromedriver.exe";
		String filepath = absolutepath + ".\\Drivers" + "\\chromedriver.exe";
		System.setProperty("Webdriver.chrome.driver", filepath);
		// System.setProperty("Webdriver.chrome.driver","C:\\selenium
		// Traning\\WorkSpace\\Mercury_Tours\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");

	}

	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}

}
