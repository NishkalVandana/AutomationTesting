import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class table {
    WebDriver driver;
    @BeforeClass
    public void setup() {
            driver=new ChromeDriver();
            driver.get("D:\\attprojects\\NewSeleniumProjects\\examples\\index.html");
            driver.manage().window().maximize();
    }
    @Test
    public  void test1(){
        int count=0;
        List <WebElement> rows=driver.findElements(By.xpath("//table//tr"));
        for(WebElement row:rows){
            List <WebElement> columns=row.findElements(By.tagName("td"));

            for(WebElement data:columns){
                System.out.print(data.getText()+" ");
                count+=1;
            }
            System.out.println();
        }
        //count of rows and columns
        System.out.println("Rows: "+rows.size());
        System.out.println("Column: "+ count/(rows.size()-1));

        //retreive specific cell data
        System.out.println(this.getCell(2,3));
    }
    private String getCell(int row,int column){
        return driver.findElement(By.xpath("//tbody/tr["+row+"]/td["+column+"]")).getText();
    }

    @AfterClass
    public void teardown(){
        driver.close();
    }
}
