package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;

    @Given("Я нахожусь на странице логина {string}")
    public void openLoginPage(String url) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        loginPage.open(url);
    }

    @When("Я ввожу логин {string}")
    public void enterUsername(String username) {
        loginPage.setUsername(username);
    }

    @When("Я ввожу пароль {string}")
    public void enterPassword(String password) {
        loginPage.setPassword(password);
    }

    @When("Я нажимаю кнопку {string}")
    public void clickLogin() {
        loginPage.clickLogin();
    }

    @Then("Я должен увидеть страницу {string}")
    public void verifyProductsPage(String expectedPage) {
        productsPage = new ProductsPage(driver);
        String currentUrl = driver.getCurrentUrl();
        if (!currentUrl.contains("inventory")) {
            throw new AssertionError("Expected products page but got: " + currentUrl);
        }
    }

    @Then("Я должен увидеть заголовок {string}")
    public void verifyPageTitle(String expectedTitle) {
        productsPage = new ProductsPage(driver);
        String actualTitle = productsPage.getPageTitle();
        if (!actualTitle.equals(expectedTitle)) {
            throw new AssertionError(
                String.format("Expected title '%s' but got '%s'", expectedTitle, actualTitle)
            );
        }
    }
}
