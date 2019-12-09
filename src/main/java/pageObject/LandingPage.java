package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	public WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@type='email']")
	WebElement email;
	
	
	@FindBy(css = "input[type='password']")
	WebElement pass;
	@FindBy(css="input[value='Log In']")
	WebElement button;
	
	
	public WebElement email()
	{
		return email;
	}
	public WebElement pass()
	{
		return pass;
	}
	public WebElement button()
	{
		return button;
	}
}
