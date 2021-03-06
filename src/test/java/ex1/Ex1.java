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
        System.out.println("Sayfa basligi : "+driver.getTitle());

        //5. Sayfa basliginin “Amazon” icerdigini test edin
        String arananBaslik = "Amazon";
        if (driver.getTitle().contains(arananBaslik)){
            System.out.println(arananBaslik+ " testi PASSED");
        } else {
            System.out.println(arananBaslik+ " testi FAILED");
        }


        //    6. Sayfa adresini(url) yazdirin
        System.out.println(driver.getCurrentUrl()); //https://www.amazon.com/

        //    7. Sayfa url’inin “amazon” icerdigini test edin.
        String arananUrl = "amazon";
        if (driver.getCurrentUrl().contains(arananUrl)){
            System.out.println(arananUrl+ " testi PASSED");
        } else {
            System.out.println(arananUrl+ " testi FAILED");
        }

        // 8. Sayfa handle degerini yazdirin


        //   9. Sayfa HTML kodlarinda “alisveris” kelimesi gectigini test edin

        String pageSources = driver.getPageSource();
        String arananKelime ="alisveris";

        if (pageSources.contains(arananKelime)){
            System.out.println(arananKelime+" testi PASSED");
        } else {
            System.out.println(arananKelime+" testi FAILED");
        }

        //    10. Sayfayi kapatin.
        driver.close();


    }

}
