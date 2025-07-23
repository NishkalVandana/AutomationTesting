package iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class framespractice {

    @Test
    public void testiframes(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/frames");
        WebElement frame1= driver.findElement(By.id("frame2"));
        driver.switchTo().frame(frame1);
        WebElement content= driver.findElement(By.tagName("h1"));
        System.out.println(content.getText());
    }
}
