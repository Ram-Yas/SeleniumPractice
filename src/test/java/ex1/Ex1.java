package ex1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Ex1 {
    /*
    1. Yeni bir package olusturalim : day01
    2. Yeni bir class olusturalim : C03_GetMethods
    3. Amazon sayfasina gidelim. https://www.amazon.com/
    4. Sayfa basligini(title) yazdirin
    5. Sayfa basliginin “Amazon” icerdigini test edin
    6. Sayfa adresini(url) yazdirin
    7. Sayfa url’inin “amazon” icerdigini test edin.
    8. Sayfa handle degerini yazdirin
    9. Sayfa HTML kodlarinda “alisveris” kelimesi gectigini test edin
    10. Sayfayi kapatin.
     */

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //    3. Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //4. Sayfa basligini(title) yazdirin
        System.out.println(driver.getTitle());

        //5. Sayfa basliginin “Amazon” icerdigini test edin
        System.out.println(driver.getTitle().contains("Amazon")); // true

        //    6. Sayfa adresini(url) yazdirin
        System.out.println(driver.getCurrentUrl()); //https://www.amazon.com/

        //    7. Sayfa url’inin “amazon” icerdigini test edin.
        System.out.println(driver.getCurrentUrl().contains("amazon")); // true
    }

}
