package testPack;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class TestNGTest {
	
  @Test
  public void f() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Jars\\chromedriver.exe");
	  WebDriver driver=new ChromeDriver();
	  driver.navigate().to("https://app.scratchmealprep.com/");
	  driver.manage().window().maximize();
	  
	  driver.findElement(By.id("login_email")).sendKeys("Satyendra@yopmail.com");
	  driver.findElement(By.id("login_pass")).sendKeys("12345678");
	  driver.findElement(By.xpath("//button[contains(@class,'mat-focus-indicator btn login ng')]")).click();
	  
	 
	  
	  
	  driver.findElement(By.xpath("//button[@class='mat-focus-indicator btn mat-flat-button mat-button-base back default-coloring ng-star-inserted']")).click();
	  WebDriverWait wait1= new WebDriverWait(driver,30);
	  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav_bar\"]/span/span/span")));
	  driver.findElement(By.xpath("//*[@id=\"nav_bar\"]/span/span/span")).click();
	  
	  Thread.sleep(5000);

	  //Click add new
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	 js.executeScript("argument[0].click()", driver.findElement(By.xpath("//div[@id='nav_panel_wrapper']/ul/li[1]//ul/li[2]")));
	  driver.findElement(By.xpath("//div[@id='nav_panel_wrapper']/ul/li[1]//ul/li[2]")).click();
	  
	  Thread.sleep(7000);
	  //add any two product to cart
	  JavascriptExecutor js1=(JavascriptExecutor)driver;
	  js1.executeScript("window.scrollBy(0,5000)");
	  
	Thread.sleep(10000);

	  //List<WebElement> ele=driver.findElements(By.xpath("//a[contains(@class,'ng-tns-c')]"));
	  //ele.get(1).click();
	  
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
