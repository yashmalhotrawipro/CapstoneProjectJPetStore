package stepdefinition;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import PageObject.homePage;
import PageObject.loginPage;
import PageObject.registerPage;
import Utility.log4j;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC5_registerWithMissingValues extends log4j{
	WebDriver driver;
	@Given("the user is on the registration page")
	public void the_user_is_on_the_registration_page() {
		driver = Hooks.driver;
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    driver.get("https://petstore.octoperf.com/");
		    writeLog("Starting register test case for missing values");
		    homePage home = new homePage(driver);
		    home.clickEnterStore();
		    loginPage login = new loginPage(driver);
		    login.clickLogin();
		    registerPage registerpage = new registerPage(driver);
		    registerpage.clickRegister();
		    writeLog("Clicked register");
	}
	@When("the user enters {string} as username and {string} as password and {string} as repeat password")
	public void the_user_enters_as_username_and_as_password_and_as_repeat_password(String username, String password, String repeatPassword) {
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("repeatedPassword")).sendKeys(repeatPassword);
		writeLog("Entered missing credentials");
	}
	@When("selects the favourite category from the drop down")
	public void selects_the_favourite_category_from_the_drop_down() {
		writeLog("Selecting favourite category");
		Select favourite = new Select(driver.findElement(By.name("account.favouriteCategoryId")));
	    favourite.selectByVisibleText("CATS");
	}
	@When("clicks Register button with missing credentials")
	public void clicks_register_button_with_missing_credentials() {
		writeLog("Clicking Register Button");
		driver.findElement(By.xpath("//input[@name='newAccount']")).click();
	}
	@Then("the user should face error")
	public void the_user_should_face_error() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		assertTrue(driver.getCurrentUrl().contains("https://petstore.octoperf.com/actions/Account.action"));
		assertTrue(driver.getPageSource().contains("Exception Report"));
		writeLog("Encountered with error because of missing credentials");
	}



}
