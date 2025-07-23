// At the top of the file

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.Arrays;
import java.util.List;

public class actions {

    WebDriver driver;
    @BeforeClass
    public void setup(){
        driver=new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/mouse-over.html");
    }

    @Test
    public void test1() throws InterruptedException{
        List <String> imglist= Arrays.asList("Compass","Calendar","Award","Landscape");
        for(String imgname:imglist){
            String locator=String.format("//img[@src='img/%s.png']",imgname.toLowerCase());
            WebElement img1=driver.findElement(By.xpath(locator));
            Thread.sleep(3000);
            Actions actions=new Actions(driver);
            actions.moveToElement(img1).build().perform();
            WebElement caption= driver.findElement(RelativeLocator.with(By.tagName("p")).near(img1));
            Assert.assertEquals(caption.getText(), imgname, "Error");
            System.out.println(caption.getText());
            Thread.sleep(3000);
        }
    }
    @Test
    public void test2(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/drag-and-drop.html");
        driver.manage().window().maximize();
        WebElement drag=driver.findElement(By.xpath("/html/body/main/div/div[4]/div[1]"));
        WebElement drop=driver.findElement(By.id("target"));
        Actions action=new Actions(driver);
        action.dragAndDrop(drag,drop).perform();
    }


}
