package tasks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class task2_can extends TestBase {


    @Test
    public void test01() {
        //    //1. "https://www.saucedemo.com" Adresine gidin
        driver.get("https://www.saucedemo.com");
        //    //2. Username kutusuna "standard_user" yazdirin
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        //    //3. Password kutusuna "secret_sauce" yazdirin
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        //    //4. Login tusuna basin
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        //    //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrun = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        String ilkUrunIsmi = ilkUrun.getText();
        ilkUrun.click();
        //    //6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        //    //7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        //    //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
      WebElement sepeteAtilanUrun = driver.findElement(By.xpath("//a[@id='item_4_title_link']"));
      String sepeteAtilanUrunText = sepeteAtilanUrun.getText();
      Assert.assertTrue(sepeteAtilanUrunText.contains(ilkUrunIsmi));
           //9. Sayfayi kapatin
    }


}
