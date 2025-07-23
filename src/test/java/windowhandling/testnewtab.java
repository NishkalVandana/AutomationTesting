package windowhandling;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testnewtab {
    WebDriver driver=new ChromeDriver();
    @Test
    public void test1(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");
        String mainhandle=driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        Assert.assertEquals(driver.getWindowHandles().size(), 2, "String message");
        driver.switchTo().window(mainhandle);

    }
}
