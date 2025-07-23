import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class alerts {
    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");
        driver.manage().window().maximize();

        // Click on the prompt button
        driver.findElement(By.id("my-prompt")).click();

        // Switch to alert and send keys
        Alert prompt = driver.switchTo().alert();
        Thread.sleep(1000); // just to visually confirm the step
        prompt.sendKeys("Hello World");
        Thread.sleep(2000);
        prompt.accept(); // Accept after sending keys

        // Now check the updated text on page
        String promptText = driver.findElement(By.id("prompt-text")).getText();
        Assert.assertEquals(promptText, "You typed: "+ "Hello World", "Prompt text mismatch!");

        driver.quit();
    }
}
