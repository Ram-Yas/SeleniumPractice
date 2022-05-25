package ex7;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Q02_WindowHandle2 extends TestBase {

    // Tests package’inda yeni bir class olusturun: WindowHandle2
    // https://the-internet.herokuapp.com/windows adresine gidin.
    // Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    // Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    // Click Here butonuna basın.
    // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    // Sayfadaki textin “New Window” olduğunu doğrulayın.
    // Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu
    //doğrulayın.


    @Test
    public void test01() {
        driver.get("https://the-internet.herokuapp.com/windows");
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        String ilkSayfaWindowHandleDegeri = driver.getWindowHandle();
        System.out.println(ilkSayfaWindowHandleDegeri);

        Assert.assertTrue(actualText.contains(expectedText));
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        String ikinciSayfaHandleDeeri = driver.getWindowHandle();
        System.out.println(ikinciSayfaHandleDeeri);
        String ikinciSayfaTitle = driver.getTitle();

        String ikinciSayfaBeklenenTitle = "New Window";
       Assert.assertTrue(ikinciSayfaTitle.contains(ikinciSayfaBeklenenTitle));
        // Sayfadaki textin “New Window” olduğunu doğrulayın.
        String beklenenMetin = "New Window";
        String actualMetin = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(actualMetin.contains(beklenenMetin));

        // Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın
        driver.switchTo().window(ilkSayfaWindowHandleDegeri);
        Assert.assertTrue(driver.getTitle().contains("The Internet"));


    }
}
