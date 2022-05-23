package tasks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class task1_can extends TestBase {

    //Notes: It may also be necessary to write code to accept the accept cookies warning.
    //1. Go to 'https://www.amazon.com.tr/'
    //2. Search iPhone13 512
    //3. Check that the results are listed
    //4. Click iPhone13 at the top of the list
    //5. Log the following values for each size
    //.Size information .Price .Color .Stock status


    @Test
    public void test01() {
        driver.get("https://www.amazon.com.tr/");
        driver.findElement(By.xpath("//input[@id='sp-cc-accept']")).click();
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iPhone13 512" + Keys.ENTER);
        WebElement resultYazisiElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(resultYazisiElementi.isDisplayed());
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();
    }
}
