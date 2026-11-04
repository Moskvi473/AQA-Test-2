package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    private static final By USERNAME_INPUT = By.xpath(
        "//input[@placeholder='Username' or @name='user-name' or contains(@id, 'user')]"
    );
    private static final By PASSWORD_INPUT = By.xpath(
        "//input[@placeholder='Password' or @name='password' or contains(@id, 'password')]"
    );
    private static final By LOGIN_BUTTON = By.xpath(
        "//button[contains(text(), 'Login') or @id='login-button' or contains(@class, 'login-button')]"
    );

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
    }

    public void setUsername(String username) {
        driver.findElement(USERNAME_INPUT).clear();
        driver.findElement(USERNAME_INPUT).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(PASSWORD_INPUT).clear();
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(LOGIN_BUTTON).click();
    }
}
