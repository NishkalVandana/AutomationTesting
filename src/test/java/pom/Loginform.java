package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Loginform {

    WebDriver driver;
    private factorylogin login;
    @Test
    public void test1(){
        driver=new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/login-form.html");
        factorylogin login=new factorylogin(driver);

        login.LoginTest("user","user");
        Assert.assertEquals(login.issuccessful(), true, "Login Success");
        Assert.assertEquals(login.isFailed(),true,"Login Failed");
    }
}
