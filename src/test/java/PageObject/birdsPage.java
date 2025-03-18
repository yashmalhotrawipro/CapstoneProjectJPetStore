package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class birdsPage {
WebDriver driver;
WebElement Bird;
public birdsPage(WebDriver driver) {
	this.driver = driver;
}

public void clickBird() {
	Bird = driver.findElement(By.xpath("//area[@alt='Birds']"));
	Bird.click();
}
}
