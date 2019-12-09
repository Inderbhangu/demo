package pageObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import resources.BrowserDriver;

public class jdbcConnection extends BrowserDriver {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String host = "localhost";
		String port = "3306";
		

		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/demo", "root", "root");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select * from credentials where scenario='zero balance'");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\personal\\Desktop\\eclipse\\Projects\\AutomationFramework\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		while(rs.next())
		{
			driver.get("http://google.com");
			driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys(rs.getString("user"));
			
			
		}
		

	}

}
