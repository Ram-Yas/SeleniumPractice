package ex1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Ex4 {

    /*
    1. Yeni bir Class olusturalim.C07_ManageWindowSet
    2. Amazon soyfasina gidelim. https://www.amazon.com/
    3. Sayfanin konumunu ve boyutlarini yazdirin
    4. Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
    5. Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
    8. Sayfayi kapatin
     */

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //    2. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        //    3. Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Actual position :"+driver.manage().window().getPosition());
        System.out.println("Actual size :"+driver.manage().window().getSize());
        //    4. Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        driver.manage().window().setPosition(new Point(50,0));
        driver.manage().window().setSize(new Dimension(850,650));
        //    5. Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
        System.out.println("Actual position :"+driver.manage().window().getPosition());
        System.out.println("Actual size :"+driver.manage().window().getSize());
        //    8. Sayfayi kapatin

        driver.close();
    }
}
