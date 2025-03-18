package stepdefinition;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import static org.testng.Assert.assertTrue;
import PageObject.homePage;
import PageObject.loginPage;
import Utility.log4j;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class TC13_multipleLogin extends log4j {
    WebDriver driver;
    List<Boolean> loginResults = new ArrayList<>();
    
    @Given("the user is on the login page for multiple login")
    public void the_user_is_on_the_login_page_for_multiple_login() {
        driver = Hooks.driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    driver.get("https://petstore.octoperf.com/");
	    homePage home = new homePage(driver);
	    home.clickEnterStore();
	    loginPage login = new loginPage(driver);
	    login.clickLogin();
    }
    @When("the user enter their username and password from excel")
    public void the_user_enter_their_username_and_password_from_excel() throws IOException {
        File file = new File("C:\\Users\\Administrator\\Desktop\\Selenuim\\CapstoneProject\\LoginExcelFile.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet("Sheet1");

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            
            // Getting user name and password from Excel
            String usernameValue = row.getCell(0).getStringCellValue();
            String passwordValue = row.getCell(1).getStringCellValue();
            
            // Reloading the login page for each new attempt
            driver.get("https://petstore.octoperf.com/");
            
            homePage home = new homePage(driver);
            home.clickEnterStore();
            
            loginPage login = new loginPage(driver);
            login.clickLogin();
            
            // enter username and pass
            WebElement username = driver.findElement(By.name("username"));
            WebElement password = driver.findElement(By.name("password"));
            
            username.clear();
            username.sendKeys(usernameValue);
            password.clear();
            password.sendKeys(passwordValue);
            
            //login button
            WebElement loginButton = driver.findElement(By.name("signon"));
            loginButton.click();
            writeLog("Attempted login with: " + usernameValue + " / " + passwordValue);
            
            //welcome message 
            try {
                WebElement welcomeMessage = driver.findElement(By.id("WelcomeContent")); 
                if (welcomeMessage.isDisplayed()) {
                    loginResults.add(true);
                    writeLog("Login successful for: " + usernameValue);
                } else {
                    loginResults.add(false);
                    writeLog("Login failed for: " + usernameValue);
                }
            } catch (Exception e) {
                loginResults.add(false);
                writeLog("Login failed for: " + usernameValue);
            }
      
            //logout
            try {
                WebElement logoutButton = driver.findElement(By.linkText("Sign Out"));
                if (logoutButton.isDisplayed()) {
                    logoutButton.click();
                    writeLog("Logged out successfully");
                } else {
                    writeLog("Logout button not found");
                }
            } catch (Exception e) {
                writeLog("Could not log out: " + e.getMessage());
            }
        } 
        workbook.close();
        inputStream.close();
    }

    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        for (int i = 0; i < loginResults.size(); i++) {
        	 assertTrue(loginResults.get(i), "Test case " + (i + 1) + " failed");
        }
    }
}





