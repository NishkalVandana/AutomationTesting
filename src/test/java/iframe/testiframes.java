package iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class testiframes {
    @Test
    public  void test1(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/iframes.html");

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("my-iframe"));
        WebElement ptag= driver.findElement(By.xpath("//p[@class='lead'][1]"));
        System.out.println(ptag.getText());
    }

    @Test
    public  void test2(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/iframes.html");

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("my-iframe"));
        List <WebElement> paras=driver.findElements(By.xpath("//p[@class='lead']"));
        Assert.assertEquals(paras.size(), 20, "String message");
        System.out.println(paras.size());

}}
