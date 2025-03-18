package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class catsPage {
WebDriver driver;
WebElement Cats;

public catsPage(WebDriver driver) {
	this.driver = driver;
}

public void clickCats() {
	Cats = driver.findElement(By.xpath("//area[@alt='Cats']"));
	Cats.click();
}
}
