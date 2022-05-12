package ex1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Ex5 {

    /*
    1.Yeni bir class olusturalim (Homework)
    2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook”
    oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
    3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i
    yazdirin.
    4.https://www.walmart.com/ sayfasina gidin.
    5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
    6. Tekrar “facebook” sayfasina donun
    7. Sayfayi yenileyin
    8. Sayfayi tam sayfa (maximize) yapin
    9.Browser’i kapatin
     */

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //    2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook”
        //    oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        driver.get("https://www.facebook.com/");
        String expectedTitle = "facebook";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle)) {
            System.out.println(expectedTitle + " test PASSED");
        } else {
            System.out.println("actualTitle is " + actualTitle);
        }
        //    3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i
        //    yazdirin.

        String expectedUrl = "facebook";
        String actualUrl = driver.getCurrentUrl();

        if (actualTitle.contains(expectedUrl)) {
            System.out.println(expectedUrl + " test PASSED");
        } else {
            System.out.println("actualURL is " + actualUrl);
        }

        //    4.https://www.walmart.com/ sayfasina gidin.
                driver.get("https://www.walmart.com/ ");
        //    5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        expectedTitle = "Walmart.com";
        actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)){
            System.out.println(expectedTitle+" test PASSED");
        } else {
            System.out.println(expectedTitle+" test FAILED");
        }
        //    6. Tekrar “facebook” sayfasina donun
        driver.navigate().back();
        //    7. Sayfayi yenileyin
        driver.navigate().refresh();
        //    8. Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();
        //    9.Browser’i kapatin
        driver.close();
    }

}
