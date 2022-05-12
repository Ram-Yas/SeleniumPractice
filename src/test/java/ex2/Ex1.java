package ex2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Ex1 {

    /*
    1. Yeni bir class olusturun (TekrarTesti)
    2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın
    (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
    3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru
    URL'yi yazdırın.
    4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
    5. Youtube sayfasina geri donun
    6. Sayfayi yenileyin
    7. Amazon sayfasina donun
    8. Sayfayi tamsayfa yapin
    9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa
    doğru başlığı(Actual Title) yazdırın.
    10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru
    URL'yi yazdırın
    11.Sayfayi kapatin
     */

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //    2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın
        //    (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.

        driver.get("https://www.youtube.com");

        String actualTitle = driver.getTitle();
        String expectedTitle = "youtube";
        if (actualTitle.contains(expectedTitle)){
            System.out.println(expectedTitle+" test PASSED");
        } else {
            System.out.println("actual Title is "+actualTitle);
        }

        //    3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru
        //    URL'yi yazdırın.
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "youtube";
        if (actualUrl.contains(expectedUrl)){
            System.out.println(actualUrl+ " test PASSED");
        } else System.out.println("actual URL is "+ actualUrl);
        //    4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.get("https://www.amazon.com");
        //    5. Youtube sayfasina geri donun
        driver.navigate().back();
        //    6. Sayfayi yenileyin
        driver.navigate().refresh();
        //    7. Amazon sayfasina donun
        driver.navigate().forward();
        //    8. Sayfayi tamsayfa yapin
        driver.manage().window().maximize();
        //    9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa
        //    doğru başlığı(Actual Title) yazdırın.
        actualTitle = driver.getTitle();
        expectedTitle = "Amazon";
        if (actualTitle.contains(expectedTitle)){
            System.out.println(expectedTitle + " test PASSED");
        } else System.out.println("actual Title is "+actualTitle);

        //    10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru
        //    URL'yi yazdırın

        actualUrl = driver.getCurrentUrl();
        expectedUrl = "https://www.amazon.com/";
        if (actualUrl.equals(expectedUrl)){
            System.out.println(actualUrl+ " test PASSED");
        } else System.out.println("actual URL is "+actualUrl);

        //    11.Sayfayi kapatin

        driver.close();
    }

}
