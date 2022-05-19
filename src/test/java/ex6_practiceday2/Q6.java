package ex6_practiceday2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Q6 {

      /*
      ...Exercise6...
   // 1. Amazon.com'a gidelim.
   // 2. DropDown üzerinde Books secelim.(All yazan yerde)
   //    kategorilerin hepsini konsola yazdiralim
   // 3. Arama kutusuna Les Miserables yazalım ve arama yapalim.
   // 4. Sonuc sayisini ekrana yazdiralim.
   // 5. Sonucların Les Miserables i icerdigini assert edelim
   */
      WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
         driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void cikis(){
        driver.close();
    }
    @Test
    public void test(){
        // 1. Amazon.com'a gidelim.
        driver.get("https://www.amazon.com");
        // 2. DropDown üzerinde Books secelim.(All yazan yerde)
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropDown);
        select.selectByIndex(5);;
        //select.selectByVisibleText("Books"); yukaridaki kod ile ayni isi yapiyor
        //    kategorilerin hepsini konsola yazdiralim

        List<WebElement> kategoriler = driver.findElements(By.xpath("//select[@id='searchDropdownBox']"));
        for (WebElement each: kategoriler
             ) {
            System.out.println(each.getText());
        }
        // 3. Arama kutusuna Les Miserables yazalım ve arama yapalim.
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Les Miserables"+ Keys.ENTER);
        // 4. Sonuc sayisini ekrana yazdiralim.
        WebElement sonucSayisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println("Bulunan sonuc sayisi "+ sonucSayisi.getText().split("over")[1].replaceAll("\\D",""));
        // 5. Sonucların Les Miserables i icerdigini assert edelim
        String expectedResult = "Les Miserables";
        String actualResult = sonucSayisi.getText();

        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}
