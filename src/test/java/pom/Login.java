package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Test
public class Login {
    WebDriver driver;
    By usernameip= By.id("username");
    By passwordip=By.id("password");
    By loginbtn=By.cssSelector("button");
    By successmsg=By.id("success");
    By errormsg=By.id("invalid");

    //constructor

    public Login(WebDriver driver){
        this.driver=driver;
    }

    private void loginaction(String username){
        driver.findElement(usernameip).sendKeys(username);
    }

    private void passwordaction(String password){
        driver.findElement(passwordip).sendKeys(password);
    }

    private  void  submitlogin(){
        driver.findElement(loginbtn).click();
    }

    public boolean issuccessful(){
         return  driver.findElement(successmsg).isDisplayed();
    }

    public boolean isFailed(){
        return  driver.findElement(errormsg).isDisplayed();
    }

    public void LoginTest(String username,String password){
        this.loginaction(username);
        this.passwordaction(password);
        this.submitlogin();
        this.issuccessful();
        this.isFailed();
    }
}
