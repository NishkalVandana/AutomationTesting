package AdvancedWebDriverFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;

public class LocationAccess {

    @Test
    public void Allowlocation()
    {
        ChromeOptions options= new ChromeOptions();
        HashMap<String,Object> prefs=new HashMap<>();
        prefs.put("profile.default_content_setting_value.geolocation",1);
        options.setExperimentalOption("prefs",prefs);
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/geolocation.html");
        driver.findElement(By.tagName("button")).click();
        WebElement coords = driver.findElement(By.id("coordinates"));
        wait.until(ExpectedConditions.visibilityOf(coords));
        Assert.assertTrue(coords.isDisplayed(), "String message");

    }
}
