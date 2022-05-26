package tasks;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public class task3_can_n11 extends TestBase {

    //1. https://www.n11.com/ adresine gidilerek headerdan “Mağazalar/Mağazaları Gör”
    //seçilir.
    //2. Tüm Mağazalar butonuna tıklanır. A harfindeki tüm mağazalar bir excel, csv veya
    //txt dosyasına yazdırılır.


    @Test
    public void test01() throws IOException {

        driver.get("https://www.n11.com/");
        Actions actions = new Actions(driver);
        WebElement magazalarYazisi = driver.findElement(By.xpath(" //span[@title='Mağazalar']"));

        //acilan location close bilgisini tiklayip, kapatir
        driver.findElement(By.id("myLocation-close-info")).click();

        //magazalarin ustune gelir
        actions.moveToElement(magazalarYazisi).perform();

        //magazalari gor'u tiklar
        driver.findElement(By.xpath(" //a[@title='Mağazaları Gör']")).click();
        driver.findElement(By.xpath("(//button[@class='dn-slide-deny-btn'])[1]")).click();
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform(); // sayfayi iki kere pagedown ile asagiya indiriyor

        String dosyaYolu = "src/resources/magazalar.txt";
        FileInputStream fis = new FileInputStream(dosyaYolu);

        WebElement aMagazalar = driver.findElement(By.xpath("(//ul)[24]")); //magazlarin oldugu bolge secildi
        String aMagazalarListesi = aMagazalar.getText(); //secilen magazalar string'e atandi
        System.out.println(aMagazalarListesi); // yazdirdigini gormek icin denedim

        File file = new File("src/resources/magazalar2.txt"); //magazalar2 isminde bir txt dosyasi olusturur

        FileUtils.writeStringToFile(file, aMagazalarListesi, Charset.defaultCharset());
        //FileUtils.writeStringToFile(file name, yazilarin oldugu string ifade, Charset.defaultCharset());
        //defaultCharset()= which returns the charset object for the default charset.
    }
}
