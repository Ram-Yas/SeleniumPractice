package ex5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q03_YoutubeAssertions {

   static WebDriver driver;

    @BeforeClass
    public static void setUp (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Bir class oluşturun: YoutubeAssertions
        //2) https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");
        driver.findElement(By.xpath("(//tp-yt-paper-button[@id='button'])[7]")).click();

        //3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    }

    @AfterClass
    public static void tearDown(){
        //driver.close();
    }

    @Test
    public void titleTest(){

            //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin

       String expectedTitle = "YouTube";
       String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

    }
    @Test
    public void imageTest(){
        //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement youtubeResmi = driver.findElement(By.xpath("//yt-icon[@id='logo-icon']"));;
        System.out.println(youtubeResmi.isDisplayed());

        System.out.println(driver.findElement(By.xpath("//input[@id='search']")).isEnabled());


    }
    @Test
    public void wrongTitleTest(){
        //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String istenmeyenBaslik = "youtube";
        String actualTitle = driver.getTitle();

       // Assert.assertFalse(actualTitle,istenmeyenBaslik);


    }
}
