package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class BrowserDriver {
	
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver browser() throws IOException
	{
		prop = new Properties();
		FileInputStream fy =new FileInputStream("C:\\Users\\personal\\Desktop\\eclipse\\Projects\\AutomationFramework\\src\\main\\java\\resources\\data.properties");
		prop.load(fy);
		String browserName =prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome"))
		{
			
			
			//Create a instance of ChromeOptions class
			ChromeOptions options = new ChromeOptions();

			//Add chrome switch to disable notification - "**--disable-notifications**"
			options.addArguments("--disable-notifications");
			

			//Set path for driver exe 
			System.setProperty("WebDriver.Chrome.driver", "C:\\Users\\personal\\Desktop\\eclipse\\Projects\\AutomationFramework\\drivers\\chromedriver.exe");

			//Pass ChromeOptions instance to ChromeDriver Constructor
			 driver =new ChromeDriver(options);
		
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("WebDriver.gecko.driver", "C:\\Users\\personal\\Desktop\\eclipse\\Projects\\AutomationFramework\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("WebDriver.edge.driver", "C:\\Users\\personal\\Desktop\\eclipse\\Projects\\AutomationFramework\\drivers\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
		return driver;
		
	}
	
	public void getScreenshot(String result) throws IOException
	{
	
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("C:\\Users\\personal\\Desktop\\eclipse\\Projects\\Screenshots\\"+result+"screenshot.png"));
		
		
		
	}
}
