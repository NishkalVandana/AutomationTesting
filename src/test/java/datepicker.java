import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class datepicker{
    WebDriver driver=new ChromeDriver();
    @Test
    public  void test1() throws InterruptedException{

        LocalDate today=LocalDate.now();
        int currentyear=today.getYear();
        int currentday=today.getDayOfMonth();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        driver.manage().window().maximize();
        //open date picker
        WebElement picker=driver.findElement(By.name("my-date"));
        picker.click();
        Thread.sleep(3000);
        //select month text
        WebElement dateswitch=driver.findElement(By.className("datepicker-switch"));
        dateswitch.click();
        Thread.sleep(3000);
        //select left arrow for year change
        WebElement arrow=driver.findElement(By.xpath("/html/body/div/div[2]/table/thead/tr[2]/th[1]"));
        arrow.click();
        Thread.sleep(3000);

        //select month
        WebElement month = driver.findElement(By.xpath("//span[@class='month focused']"));
        month.click();

        String day=String.format("//td[@class='day' and text()='%d']",currentday);
        WebElement daytoday= driver.findElement(By.xpath(day));
        daytoday.click();

        DateTimeFormatter date=DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate previousdate=today.minusYears(1);
        String pastdate=previousdate.format(date);
        System.out.println(picker.getDomProperty("value"));
        System.out.println(pastdate);
        Assert.assertEquals(picker.getDomProperty("value"), pastdate, "String message");


        //select date
    }
}
