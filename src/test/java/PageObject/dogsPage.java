package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class dogsPage {
WebDriver driver;
WebElement Dogs;

public dogsPage(WebDriver driver) {
	this.driver = driver;
}

public void clickDogs() {
	Dogs = driver.findElement(By.xpath("//area[@alt='Dogs']"));
	Dogs.click();
}
}
