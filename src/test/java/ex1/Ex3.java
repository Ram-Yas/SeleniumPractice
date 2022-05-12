package ex1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Ex3 {

    /*
    1. Yeni bir Class olusturalim.C06_ManageWindow
    2. Amazon soyfasina gidelim. https://www.amazon.com/
    3. Sayfanin konumunu ve boyutlarini yazdirin
    4. Sayfayi simge durumuna getirin
    5. simge durumunda 3 saniye bekleyip sayfayi maximize yapin
    6. Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
    7. Sayfayi fullscreen yapin
    8. Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
    9. Sayfayi kapatin
     */
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 2. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com");
        // Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Sayfanin actuel konumu : " + driver.manage().window().getPosition());
        System.out.println("Sayfanin actuel boyutlari : " + driver.manage().window().getSize());

        // 4. Sayfayi simge durumuna getirin
        driver.manage().window().minimize();

        //    5. simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        Thread.sleep(3000);

        // 6. Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        driver.manage().window().maximize();
        // 7. Sayfayi fullscreen yapin
        driver.manage().window().fullscreen();
        // 8. Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        System.out.println("Sayfanin actual konumu : " + driver.manage().window().getPosition());
        System.out.println("Sayfanin actual boyutlari : " + driver.manage().window().getSize());
        // 9. Sayfayi kapatin
        driver.close();

    }
}
