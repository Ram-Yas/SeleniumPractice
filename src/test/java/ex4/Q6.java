package ex4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q6 {
      /*
    // ...Exercise6...
    1.  https://id.heroku.com/login sayfasina gidin
    2.  Bir mail adersi giriniz
    3.  Bir password giriniz
    4.  Login butonuna tiklayiniz
    5.  "There was a problem with your login." texti gorunur ise
    6.  "kayit yapilamadi" yazdiriniz
    8.  eger yazi gorunur degilse "kayit yapildi" yazdiriniz
    9.  Tum sayfalari kapatiniz
     */

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //  1.  https://id.heroku.com/login sayfasina gidin
        driver.get("https://id.heroku.com/login");
        //    2.  Bir mail adersi giriniz
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("ramazan@gmail.com");
        //    3.  Bir password giriniz
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("12345678");
        //    4.  Login butonuna tiklayiniz
        driver.findElement(By.xpath("//button[@name='commit']")).click();
        //    5.  "There was a problem with your login." texti gorunur ise
        //    6.  "kayit yapilamadi" yazdiriniz
        if(driver.findElement(By.xpath("//h2[@class='h3']")).isDisplayed()){
            System.out.println("kayit yapilamadi");
        }
        //    8.  eger yazi gorunur degilse "kayit yapildi" yazdiriniz
        else System.out.println("kayit yapildi");

        //    9.  Tum sayfalari kapatiniz
        driver.close();
    }
}