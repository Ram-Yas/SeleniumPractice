package ex4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Ex2_AmazonSearch {

    //1- https://www.amazon.com/ sayfasina gidelim
    //2- arama kutusunu locate edelim
    //3- “Samsung headphones” ile arama yapalim
    //4- Bulunan sonuc sayisini yazdiralim
    //5- Ilk urunu tiklayalim
    //6- Sayfadaki tum basliklari yazdiralim

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
   //     driver.close();
    }

    @Test
    public void method1(){
        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotbsearchtextbox")).sendKeys("Samsung headphones"+ Keys.ENTER);
        WebElement bulunanSonucSayisi = (WebElement) driver.findElements(By.xpath("//*[.='1-16 of over 1,000 results for']"));

    }

}
