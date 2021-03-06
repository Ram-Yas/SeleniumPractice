package ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Review {

    /*
    1. Bir class oluşturun : AmazonSearchTest
    2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
        a.google web sayfasına gidin. https://www.amazon.com/
        b. Search(ara) “city bike”
        c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        d. “Shopping” e tıklayın.
        e. Sonra karşınıza çıkan ilk sonucun resmine tıklayın
     */
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // a.google web sayfasına gidin. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

            //   b. Search(ara) “city bike”
        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("city bike"+ Keys.ENTER);

        // c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın  yapamadim

        List<WebElement> istenenElementlerListesi = driver.findElements(By.className("sg-col-inner"));
        WebElement sonucYazisi = istenenElementlerListesi.get(0);

        System.out.println(sonucYazisi.getText());

        //        d. “Shopping” e tıklayın. shopping yok
        //        e. Sonra karşınıza çıkan ilk sonucun resmine tıklayın

        List<WebElement> urunListesiResimleri = driver.findElements(By.className("s-image"));
        WebElement ucuncuUrunResmi = urunListesiResimleri.get(2);
        ucuncuUrunResmi.click();
        Thread.sleep(2000);

        driver.quit();


    }

}
