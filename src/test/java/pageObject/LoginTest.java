package pageObject;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.BrowserDriver;

public class LoginTest extends BrowserDriver {
	
	private static final Logger log = LogManager.getLogger(LoginTest.class.getName());
	
	public WebDriver driver;
	@Test(dataProvider="getdata", groups = {"smoke"})
	public void login(String user, String pass) throws IOException, InterruptedException
	{
		driver=browser();
		LandingPage l = new LandingPage(driver);
		driver.get(prop.getProperty("url"));
		log.info("Login FB");
		l.email().sendKeys(user);
		l.pass().sendKeys(pass);
		l.button().click();
		log.error("Login Failed");
		Thread.sleep(4000);
	

	}
	@Test(groups = {"smoke"})
	public void signup() throws IOException
	{
		driver=browser();
		driver.get(prop.getProperty("url2"));
		log.info("flipkart");
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Facebook"));
		
	}
	

	
	@DataProvider
	public Object[][] getdata()
{
		return new Object[][]
				{
			{"bhangu007@gmail.com","secretoflife"},
			{"abc@gmail.com","123456"}
				};
}
	@AfterMethod(groups = {"smoke"})
	public void quit() throws InterruptedException
	{
		
		driver.close();
	}
	
	

	
	

}
