package ex1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Ex2 {
    /*
    1. Yeni bir Class olusturalim.C05_NavigationMethods
    2. Youtube ana sayfasina gidelim . https://www.youtube.com/
    3. Amazon soyfasina gidelim. https://www.amazon.com/
    4. Tekrar YouTube’sayfasina donelim
    5. Yeniden Amazon sayfasina gidelim
    6. Sayfayi Refresh(yenile) yapalim
    7. Sayfayi kapatalim / Tum sayfalari kapatalim
     */

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //    2. Youtube ana sayfasina gidelim . https://www.youtube.com/
        driver.get("https://www.youtube.com"); //
        driver.get("https://www.amazon.com"); // Amazon soyfasina gidelim. https://www.amazon.com/
        driver.navigate().back(); // Tekrar YouTube’sayfasina donelim
        driver.navigate().forward(); //     5. Yeniden Amazon sayfasina gidelim

        driver.navigate().refresh(); //    6. Sayfayi Refresh(yenile) yapalim
        driver.close(); //     7. Sayfayi kapatalim / Tum sayfalari kapatalim

    }
}
