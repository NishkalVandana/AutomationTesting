package windowhandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class swtichtab {

    @Test
    public  void testswitching(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");
        String mainhandle=driver.getWindowHandle();
        WebElement tab= driver.findElement(By.id("tabButton"));
        tab.click();
        Set<String> allHandles=driver.getWindowHandles();
        for (String hande:allHandles){
            if(!hande.equals(mainhandle)){
                driver.switchTo().window(hande);
            }
        }
        System.out.println(driver.findElement(By.tagName("body")).getText());
    }
}
