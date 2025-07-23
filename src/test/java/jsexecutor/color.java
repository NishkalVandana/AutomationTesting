package jsexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;

public class color {

    @Test
    public  void  colorpicker(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        WebElement color=driver.findElement(By.name("my-colors"));
        String intialcolor=color.getDomAttribute("value");
        System.out.println("Intial color is: "+ Color.getColor(intialcolor));
        String red="#FF0000";
        String script=String.format("arguments[0].setAttribute('value','%s')",red);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript(script,color);
        Assert.assertNotEquals(intialcolor, color.getDomAttribute("value"), "String message");
        System.out.println("New Color is: "+color.getDomAttribute("value"));

    }
}
