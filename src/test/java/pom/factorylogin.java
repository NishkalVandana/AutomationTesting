package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class   factorylogin {
    WebDriver driver;

    @FindBy(id = "username")
    WebElement usernameip;

    @FindBy(id = "password")
    WebElement passwordip;

    @FindBy(css = "button")
    WebElement loginbtn;

    // constructor
    public factorylogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void loginaction(String username) {
        usernameip.sendKeys(username);
    }

    private void passwordaction(String password) {
        passwordip.sendKeys(password);
    }

    private void submitlogin() {
        loginbtn.click();
    }

    public boolean issuccessful() {
        return !driver.findElements(By.id("success")).isEmpty();
    }

    public boolean isFailed() {
        return !driver.findElements(By.id("invalid")).isEmpty();
    }

    public void LoginTest(String username, String password) {
        loginaction(username);
        passwordaction(password);
        submitlogin();
    }
}
