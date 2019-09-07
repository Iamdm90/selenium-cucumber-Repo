package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class LoginStepDefinition {
	WebDriver driver;
	
	@Given("^user is already on Login Page$")
	public void user_already_on_login_page()
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}
	
	@When("^title of login page is Amazon.com$")
	public void title_of_login_page_is_Free_CRM()
	{
		String title = driver.getTitle();
		System.out.println("Title of the page is: "+ title);
		Assert.assertEquals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more", title);
	}
	
	@Then("^user enters username and password$")
	public void user_enters_username_and_password() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement accounts_signIn = driver.findElement(By.xpath("//span[@class='nav-line-2'][contains(text(),'Account & Lists')]"));
		accounts_signIn.click();
		WebElement email_id = driver.findElement(By.xpath("//input[@id='ap_email']"));
		email_id.sendKeys("");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='ap_password']"));
		pwd.sendKeys("");
		
	    
	}

	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button(){
	    // Write code here that turns the phrase above into concrete actions
		WebElement submit_button = driver.findElement(By.xpath("//input[@id='signInSubmit']"));
		submit_button.click();
	}

	@Then("^user is on home page$")
	public void user_is_on_home_page(){
	    // Write code here that turns the phrase above into concrete actions
		String account_name = driver.findElement(By.xpath("//a[@id='nav-link-accountList']/span[1]")).getText();
		System.out.println("The account name is showing as: "+ account_name);
		Assert.assertEquals("Hello, Debjit", account_name);
	}	

}
