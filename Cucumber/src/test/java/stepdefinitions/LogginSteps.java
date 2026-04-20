package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LogginPage;
import pageObjects.MyAccountPage;

public class LogginSteps {

    WebDriver driver;

    HomePage hp;
    LogginPage lp;
    MyAccountPage macc;

    // ✅ Constructor to ensure driver is available
    public LogginSteps() {
        driver = BaseClass.getDriver();
    }

    @Given("the user navigates to login page")
    public void user_navigate_to_login_page() {

        hp = new HomePage(driver);

        hp.clickMyAccount();
        hp.clickLogin();
    }

    @When("user enters email as {string} and password as {string}")
    public void user_enters_email_as_and_password_as(String email, String pwd) {

        lp = new LogginPage(driver);

        lp.setEmail(email);
        lp.setPassword(pwd);
    }

    @When("the user clicks on the Login button")
    public void click_on_login_button() {

        lp.clickLogin();
    }

    @Then("the user should be redirected to the MyAccount Page")
    public void user_navigates_to_my_account_page() {

        macc = new MyAccountPage(driver);

        boolean status = macc.isMyAccountPageExists();

        Assert.assertTrue(status);
    }
}