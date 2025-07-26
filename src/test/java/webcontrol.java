import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class webcontrol {
    WebDriver driver;
    @BeforeClass
    public void setup(){
       driver=new ChromeDriver();
       driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
    }
    @Test
    public void test1() {
        WebElement dropdown = driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/label[1]/select"));
        Select select = new Select(dropdown);
        select.selectByIndex(2);
        Assert.assertEquals(select.getFirstSelectedOption().getDomAttribute("value"), "2");

    }
}
