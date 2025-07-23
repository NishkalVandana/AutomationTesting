// At the top of the file

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class copypaste {
    WebDriver driver=new ChromeDriver();
    @Test
    public void test3() throws InterruptedException{
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        driver.manage().window().maximize();
        WebElement input=driver.findElement(By.id("my-text-id"));
        WebElement text=driver.findElement(By.name("my-textarea"));
        Actions actions=new Actions(driver);
        actions.moveToElement(input).click().sendKeys("Hello World");
        Thread.sleep(3000);
        actions.click(input).keyDown(Keys.CONTROL)
                .sendKeys(input,"a")
                .sendKeys(input,"c")
                .keyUp(Keys.CONTROL)
                .click(text).keyDown(Keys.CONTROL)
                .sendKeys("v").keyUp(Keys.CONTROL).build().perform();
        Assert.assertEquals(text.getDomAttribute("value"), input.getDomAttribute("value"), "String message");
    }
}
