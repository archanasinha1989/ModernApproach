package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObjects.LandingPage;

import resources.base;

public class ProductDetailsPage extends base{
	public WebDriver driver;
	
	 public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();
		 driver.get(prop.getProperty("urlV2"));
	}
	@Test(priority=1)
	
	public void ProductDetailsPages() throws IOException, InterruptedException
	{

		LandingPage lp=new LandingPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
		
		//click on Product
		
	   
		  clicklink("findElementByXPath", lp.Product, driver, " Product");
		
		//click on size dropdown
	     js.executeScript("window.scrollBy(0,500)");
		clicklink("findElementByXPath", lp.SizeChat, driver, " size dropdown");
		
		
         initiateEyes();
		
		validatewindow(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	@AfterTest
	public void teardown()
	{
		
		driver.close();
	
		
	}


}


