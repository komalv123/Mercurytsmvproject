package Test.Mercurytsmvproject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class MercuryTestTour 
{
	public WebDriver driver;
	
	@Test(priority=1,description="Verify that the valid user is able to login")
	  public void loginwithValidDetails() 
	  {
		  System.out.println("In loginwithValidDetails method under @Test");
		  String act_title=driver.getTitle();
		  String exp_title="Welcome: Mercury Tours";
		  Assert.assertEquals(act_title, exp_title);
		  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("diptichopade");
		  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("chopade123");
		  driver.findElement(By.xpath("//input[@name='login']")).click();
		  System.out.println("Login Successfully");
		  
		  boolean act_flag=driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
		  boolean exp_flag=true;
		  Assert.assertEquals(act_flag, exp_flag);
		  System.out.println("Flight finder is diplayed");
		  driver.findElement(By.linkText("SIGN-OFF")).click();
	  }
	  
	 @Test(priority=2,description="Verify that the valid user2 is able to login")
	  public void loginwithValidDetails2() 
	  {
		  System.out.println("In loginwithValidDetails method under @Test");
		  
		  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("komalv");
		  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("komal123");
		  driver.findElement(By.xpath("//input[@name='login']")).click();
		  System.out.println("Login Successfully");
		  
		  boolean act_flag=driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
		  boolean exp_flag=true;
		  Assert.assertEquals(act_flag, exp_flag);
		  System.out.println("Flight finder is diplayed");
		  driver.findElement(By.linkText("SIGN-OFF")).click();
	  }
	
//	 @Test(priority=3,description="Verify that the valid user3 is able to login")
//	  public void loginwithInvalidDetails() 
//	  {
//		  System.out.println("In loginwithInvalidDetails method under @Test");
//		  String act_title=driver.getTitle();
//		  String exp_title="Welcome: Mercury Tours";
//		  Assert.assertEquals(act_title, exp_title);
//		  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("diptic");
//		  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("chopade123");
//		  driver.findElement(By.xpath("//input[@name='login']")).click();
//		  System.out.println("Login Successfully");
//		  
//		  boolean act_flag=driver.findElement(By.xpath("//img[@sr='/images/masts/mast_flightfinder.gif']")).isDisplayed();
//		  boolean exp_flag=true;
//		  Assert.assertEquals(act_flag, exp_flag);
//		  System.out.println("Flight finder is diplayed");
//		  driver.findElement(By.linkText("SIGN-OFF")).click();
//	  }
//	  
	  
	  @BeforeMethod
	  public void getcookies() 
	  {
		  System.out.println("In getcokkies method under @BeforeMethod");
		  Set<Cookie>k=driver.manage().getCookies();
		  for(Cookie coo : k)
		  {
			  System.out.println("Cookies Name: "+coo.getName());
			  System.out.println("Value of cookie"+coo.getValue());
		  }
	  }

	  @AfterMethod
	  public void captureScreenshot (ITestResult  result) throws IOException  
	  {
		  if(result.FAILURE==result.getStatus())
		  {
		  System.out.println("In captureScreenshot method under @AfterMethod");
		  System.out.println("Fail Test:"+result.getName());
		  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(src, new File("E:\\Core Java\\Mercurytsmvproject\\src\\test\\resources\\Screenshot.jpg"));
		  System.out.println("screenshot is captured is successfully");
		  }
	  }

	  @BeforeClass
	  public void maximumBrowser() 
	  {
		  System.out.println("In maximumBrowser method under @BeforeClass");
		  driver.manage().window().maximize();
		  System.out.println("Window maximize successfully");
	  }

	  @AfterClass
	  public void deleteAllCokkies() 
	  {
		  System.out.println("In deleteAllCokkies method under @AfterClass");
		  driver.manage().deleteAllCookies();
		  System.out.println("All cokkies are delete successfully");
	  }

	  @BeforeTest
	  public void enterApplUrl() 
	  {
		  System.out.println("In enterApplUrl method under @BeforeTest");
		  driver.get("http://newtours.demoaut.com/");
		  System.out.println("New tourse Url open successfully");
	  }

	  @AfterTest
	  public void dbConnection() 
	  {
		  System.out.println("In dbConnection method under @AfterTest");
	  }

	  @BeforeSuite
	  public void openBrowser() 
	  {
		  System.out.println("In openbrowser method under @BeforeSuite");
		  System.setProperty("webdriver.chrome.driver","F:\\Selenium Setup\\Setup\\chromedriver_win32\\chromedriver.exe");
		  driver=new ChromeDriver();
		  System.out.println("Chrome browser open successfully"); 
	  }

	  @AfterSuite
	  public void closeBrowser() 
	  {
		  System.out.println("In closeBrowser method under @AfterSuite");
		  driver.close();
		  System.out.println("Browser closed succefully"); 
	  }

}
