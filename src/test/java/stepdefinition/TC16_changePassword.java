package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.assertTrue;
import PageObject.homePage;
import PageObject.loginPage;
import Utility.log4j;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC16_changePassword extends log4j {
	WebDriver driver;
	@Given("user is logged in")
	public void user_is_logged_in() {
		driver = Hooks.driver;
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://petstore.octoperf.com/");
	    writeLog("Starting Logout Test Case");
	    homePage home = new homePage(driver);
		home.clickEnterStore();
		loginPage login = new loginPage(driver);
		login.clickLogin();
		driver.findElement(By.name("username")).sendKeys("username1");
		WebElement password = driver.findElement(By.name("password"));
		password.clear();
		password.sendKeys("password1");
		driver.findElement(By.name("signon")).click();
		writeLog("User is logged in");
	}
	@When("user navigates to the change password page")
	public void user_navigates_to_the_change_password_page() {
		 driver.findElement(By.linkText("My Account")).click();
	}
	@When("user enters a new password {string} and confirms it {string}")
	public void user_enters_a_new_password_and_confirms_it(String newPass, String confirmPass) {
	   driver.findElement(By.name("password")).sendKeys(newPass);
	   writeLog("Entered new password");
	   driver.findElement(By.name("repeatedPassword")).sendKeys(confirmPass);
	   writeLog("confirmed new password");
	}
	
	@When("user submits the password change request")
	public void user_submits_the_password_change_request() {
	    driver.findElement(By.name("editAccount")).click();
	}
	@Then("a confirmation message {string} should be displayed")
	public void a_confirmation_message_should_be_displayed(String updateMessage) {
	    assertTrue(driver.getPageSource().contains(updateMessage));
	}



}
