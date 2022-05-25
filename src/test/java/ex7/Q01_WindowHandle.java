package ex7;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class Q01_WindowHandle extends TestBase {

    @Test
    public void test01() {

        //● Yeni bir class olusturun: WindowHandle
        //● Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");
        //● Sayfa’nin window handle degerini String bir degiskene atayin
        String ilkSayfaWindowHandleDegeri = driver.getWindowHandle();
        System.out.println(ilkSayfaWindowHandleDegeri);
        //● Sayfa title’nin “Amazon” icerdigini test edin
        String expectedTitle = "Amazon";
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));
        //● Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.techproeducation.com");
        //● Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        String ikinciSayfaWindowHandleDegeri = driver.getWindowHandle();
        System.out.println(ikinciSayfaWindowHandleDegeri);
        String actualIkinciTitle = driver.getTitle();
        String expectedIkinciTitle = "TECHPROEDUCATION";
        Assert.assertTrue(actualIkinciTitle.contains(expectedIkinciTitle));

        //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");
        //● Sayfa title’nin “Walmart” icerdigini test edin
        String expectedUcuncuTitle = "Walmart";
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));
        //● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin

        driver.switchTo().window(ilkSayfaWindowHandleDegeri);


    }
}
