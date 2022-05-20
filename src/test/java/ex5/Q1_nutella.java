package ex5;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Q1_nutella extends TestBase {

    //1-C01_TekrarTesti isimli bir class olusturun
    //2- https://www.google.com/ adresine gidin
    //3- cookies uyarisini kabul ederek kapatin
    //4-Sayfa basliginin “Google” ifadesi icerdigini test edin
    //5- Arama cubuguna “Nutella” yazip aratin
    //6-Bulunan sonuc sayisini yazdirin
    //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
    //8-Sayfayi kapatin


    @Test
    public void test01() {

        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        //3- cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("//button[@id='L2AGLb']")).click();

        //4-Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        String expaectedTitle = "Google";
        Assert.assertTrue(actualTitle.contains(expaectedTitle));

        //5- Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Nutella" + Keys.ENTER);

        //6-Bulunan sonuc sayisini yazdirin
        String sonuclar = driver.findElement(By.xpath("//div[@id='result-stats']")).getText();
        String sonucSayisi = sonuclar.split("résultats ")[0].replaceAll("\\D", "");
        System.out.println("Bulunan sonuc sayisi = " + sonucSayisi);
        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin

        int sonucInt= Integer.parseInt(sonucSayisi);
        boolean buyukMu = sonucInt>10000000;
        Assert.assertTrue("Sonuc sayisi 10 milyondan buyuk degil",sonucInt>100000000);

        //8-Sayfayi kapatin
    }
}
