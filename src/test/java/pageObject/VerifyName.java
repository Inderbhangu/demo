package pageObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import junit.framework.Assert;
import resources.BrowserDriver;

public class VerifyName extends BrowserDriver {

	private static final Logger log = LogManager.getLogger(VerifyName.class.getName());

	public WebDriver driver;

	@SuppressWarnings("deprecation")
	
	@Test(dataProvider = "getdata", groups = {"Reg"})
	public void testName(String user, String pass) throws IOException, InterruptedException {
		driver = browser();
		driver.get(prop.getProperty("url"));
		log.info("Facebook");
		LandingPage l = new LandingPage(driver);
		l.email().sendKeys(user);
		l.pass().sendKeys(pass);
		l.button().click();
		log.error("Unable to login");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		HomePage hp = new HomePage(driver);

		String actual = hp.name().getText();
		Assert.assertEquals("Inder Bhangu", actual);
	}

	@Parameters({"first_name","last_name"})
	@Test()
	public void name(String first, String last)
	{
	System.out.println(first+" "+last);	
	}
	
	@DataProvider
	public Object[][] getdata() {
		return new Object[][] { { "bhangu007@gmail.com", "secretoflife" },

		};
	}

	@AfterTest(groups = {"Reg"})

	public void close() {
		System.out.println("git update");
		System.out.println("git develop");
		
		driver.close();
	}

}
