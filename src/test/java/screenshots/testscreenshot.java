package screenshots;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class testscreenshot {

    @Test
    public void test1() throws IOException {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File ss = takesScreenshot.getScreenshotAs(OutputType.FILE);
        Path destination = Path.of("screenshot.png");
        Files.move(ss.toPath(), destination, REPLACE_EXISTING);
        Assert.assertTrue(Files.exists(destination), "Screenshot file does not exist!");
        Assert.assertTrue(Files.size(destination) > 0, "Screenshot file is empty!");
    }
}