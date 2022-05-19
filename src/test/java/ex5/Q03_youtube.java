package ex5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q03_youtube {

    WebDriver driver;

    @Before
    public void setUp (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test(){
        driver.get("https://www.youtube.com");
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("ben bir ceviz agaciydim"+ Keys.ENTER);
        driver.findElement(By.xpath("(//img[@class='style-scope yt-img-shadow'])[1]")).click();
    }
}