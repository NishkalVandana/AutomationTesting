// At the top of the file

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testselenium {

    WebDriver d;

    @BeforeClass
    public void setup() {
        d = new ChromeDriver();
        d.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
    }

    @Test
    public void testRelativeLocatorAbove() {
        WebElement a = d.findElement(By.id("my-text-id"));
        WebElement pass = d.findElement(RelativeLocator.with(By.tagName("input")).below(a));
        Assert.assertEquals(pass.getDomAttribute("name"), "my-password");
    }

    @AfterClass
    public void tearDown() {
        d.quit();
    }
}
