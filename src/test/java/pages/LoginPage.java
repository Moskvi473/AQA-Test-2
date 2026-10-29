package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='Username' or @name='user-name' or contains(@id, 'user')]")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@placeholder='Password' or @name='password' or contains(@id, 'password')]")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[contains(text(), 'Login') or @id='login-button' or contains(@class, 'login-button')]")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open(String url) {
        driver.get(url);
    }

    public void setUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }
}
