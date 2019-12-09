package stepDefinations;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.LandingPage;
import resources.BrowserDriver;

public class stepdefination extends BrowserDriver {
	public WebDriver driver;
	
	
	
	 @Given("^User is on \"([^\"]*)\"$")
	    public void user_is_on_something(String strArg1) throws Throwable {
	        driver=browser();
	        driver.get(strArg1);
	    }
	 @When("^User login with (.+) and (.+)$")
	    public void user_login_with_and(String username, String password) throws Throwable {
		 LandingPage l = new LandingPage(driver);
	    	l.email().sendKeys(username);
	    	l.pass().sendKeys(password);
	    	l.button().click();
	    	Thread.sleep(3000);
	    	System.out.println(driver.getTitle());
	    }


	    

	    @Then("^Homepage is populated$")
	    public void homepage_is_populated() throws Throwable {
	    
	        
	    }

	    @And("^Friends are \"([^\"]*)\" or \"([^\"]*)\"$")
	    public void friends_are_something_or_something(String strArg1, String strArg2) throws Throwable {
	    	if(driver.getTitle().equalsIgnoreCase("Facebook"))
	    	{
	    		System.out.println("Friends are"+" "+strArg1);
	    		driver.close();
	    	}
	    	else
	    	{
	    		System.out.println("Friends are"+" "+strArg2);
	    		driver.close();
	    	}
	       
	    }

}
