package jsexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class jsetest {

    WebDriver driver=new ChromeDriver();
    @BeforeClass
    public void setup(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/long-page.html");
        driver.manage().window().maximize();

    }

    @Test
    public void test1(){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        String script="window.scrollBy(0,600)";
        js.executeScript(script);
    }

    @Test
    public  void  test2(){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        WebElement lastpara=driver.findElement(By.cssSelector("p:last-child"));
        String script="arguments[0].scrollIntoView(true);";
        js.executeScript(script,lastpara);
    }

}
