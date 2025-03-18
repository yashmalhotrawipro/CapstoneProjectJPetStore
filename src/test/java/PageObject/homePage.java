package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homePage {
	WebDriver driver;
	WebElement enterstore;
	
	public homePage(WebDriver driver) {
		this.driver =  driver;
		}
	
	public void clickEnterStore() {
		enterstore = driver.findElement(By.linkText("Enter the Store"));
		enterstore.click();
	}
}
