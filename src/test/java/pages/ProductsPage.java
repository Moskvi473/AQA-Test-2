package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {

    private WebDriver driver;

    private static final By PAGE_TITLE = By.xpath("//div[@class='title']");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.findElement(PAGE_TITLE).getText();
    }

    public boolean isPageVisible() {
        return driver.findElement(PAGE_TITLE).isDisplayed();
    }
}
