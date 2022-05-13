package ex3_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Review {

    /*
    2- https://www.amazon.com/ adresine gidin
    3- Browseri tam sayfa yapin
    4- Sayfayi “refresh” yapin
    5- Sayfa basliginin “Spend less” ifadesi icerdigini test edin
    6- Gift Cards sekmesine basin
    7- Birthday butonuna basin
    8- Best Seller bolumunden ilk urunu tiklayin
    9- Gift card details’den 25 $’i secin
    10-Urun ucretinin 25$ oldugunu test edin
    10-Sayfayi kapatin
     */

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //    2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        // 3- Browseri tam sayfa yapin
        driver.manage().window().maximize();

        //    4- Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //    5- Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Spend less";

        if (actualTitle.contains(expectedTitle)){
            System.out.println(expectedTitle + " test PASSED");
        }else{
            System.out.println(expectedTitle + " test FAILED");
        }
        //    6- Gift Cards sekmesine basin

        WebElement giftCardButton = driver.findElement(By.tagName("nav_cs_gc"));
        giftCardButton.click();

        //    7- Birthday butonuna basin
        //    8- Best Seller bolumunden ilk urunu tiklayin
        //    9- Gift card details’den 25 $’i secin
        //    10-Urun ucretinin 25$ oldugunu test edin
        //    10-Sayfayi kapatin


    }
}
