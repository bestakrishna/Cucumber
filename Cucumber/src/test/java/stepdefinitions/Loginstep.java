package stepdefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Loginstep {
	WebDriver driver;

	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	     driver=new ChromeDriver();
	    driver.get("https://tutorialsninja.com/demo/index.php?route=common/home ");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.manage().window().maximize();
	    driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
	    driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
		
	}

	@When("user enters valid credentials \\(user name:{string} and password:{string})")
	public void user_enters_valid_credentials_user_name_and_password(String user, String pwd) {
	    driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys(user);
	    driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys(pwd);
	}

	@When("user clicks the login button")
	public void NavigteToLoginPage() {//we can change the name as well
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
	}

	@Then("user should be redirected to the my account page")
	public void user_should_be_redirected_to_the_my_account_page() {
	    // Write code here that turns the phrase above into concrete actions
	  boolean status= driver.findElement(By.xpath("//*[@id=\"content\"]/h2[1]")).isDisplayed();//validation
	  Assert.assertEquals(status,true);
	}

	@Then("user should see a welcome message")
	public void user_should_see_a_welcome_message() {
	    // Write code here that turns the phrase above into concrete actions
	  boolean txt=  driver.findElement(By.xpath("//*[@id=\"logo\"]/h1/a")).isDisplayed();
	  Assert.assertEquals(txt,true); 
	  driver.quit();
	}

	
	
	
	
	
}
