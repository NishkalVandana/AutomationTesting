package CrossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class crossbrowsertesting {
   private  WebDriver driver;

   @Test(dataProvider = "getbrowserdata")
    public  void test1(String browser){
        this.intializebrowser(browser);
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
       Assert.assertEquals(driver.getTitle(), "Hands-On Selenium WebDriver with Java", "String message");
       System.out.println("PASSED:"+browser);
   }

@DataProvider
public Object[][] getbrowserdata(){
    return  new Object[][]{
            {"Chrome"},{"Edge"},{"Firefox"}
    };
}
public  void intializebrowser(String browser){
    if(browser.equalsIgnoreCase("chrome")){
        driver=new ChromeDriver();
    }
    else if(browser.equalsIgnoreCase("edge")){
        System.setProperty("webdriver.edge.driver", "C:\\Users\\asus\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();

    }
    else if(browser.equalsIgnoreCase("Firefox")){
        driver=new FirefoxDriver();
    }
    else {
        throw new IllegalArgumentException("Unsupported Browser");
    }
    }
}
