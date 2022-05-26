package tasks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class task1_can extends TestBase {

    //Notes: It may also be necessary to write code to accept the accept cookies warning.
    //1. Go to 'https://www.amazon.com.tr/'
    //5. Log the following values for each size
    //.Size information .Price .Color .Stock status


    @Test
    public void test01() throws InterruptedException {

        //1. Go to 'https://www.amazon.com.tr/'
        driver.get("https://www.amazon.com.tr/");

        //this line is for the cookies
        driver.findElement(By.xpath("//input[@id='sp-cc-accept']")).click();
        //2. Sea rch iPhone13 512
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iPhone13 512" + Keys.ENTER);

        //3. Check that the results are listed
        WebElement resultYazisiElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(resultYazisiElementi.isDisplayed());

        //4. Click iPhone13 at the top of the list
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();

        if (driver.findElement(By.xpath("(//li[@class='swatch-list-item-text inline-twister-swatch a-declarative desktop-configurator-dim-row-0'])[1]")).isDisplayed()) {
            List<WebElement> list = driver.findElements(By.xpath("//li[@class='swatch-list-item-text inline-twister-swatch a-declarative desktop-configurator-dim-row-0']"));
            for (int i = 0; i < list.size(); i++) {
                list.get(i).click();
                System.out.println(driver.findElement(By.id("productTitle")).getText() + " " + "Size : " + driver.findElement(By.xpath("(//span[@class='a-size-base a-color-base inline-twister-dim-title-value a-text-bold'])[2]")).getText());
                System.out.println("Color: " + driver.findElement(By.xpath("(//span[@class='a-size-base a-color-base inline-twister-dim-title-value a-text-bold'])[1]")).getText() + " " + "Price : " + driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText() + "," + driver.findElement(By.xpath("//span[@class='a-price-fraction']")).getText() + "TL");
                System.out.println("Stock: " + driver.findElement(By.xpath("//div[@id='availability']")).getText());
                System.out.println("---------------------------------------------------------------------------------------");
                Thread.sleep(5000);
            }
        } else if(driver.findElement(By.xpath("(//p[@class='a-text-left a-size-base'])")).isDisplayed()) {

            List<WebElement> list = driver.findElements(By.xpath("(//p[@class='a-text-left a-size-base'])"));
            for (int i = 0; i < list.size(); i++) {
                list.get(i).click();
                System.out.println(driver.findElement(By.id("productTitle")).getText() + " " + "Size : " + driver.findElement(By.xpath("(//span[@class='a-size-base a-color-base inline-twister-dim-title-value a-text-bold'])[2]")).getText());
                System.out.println("Color: " + driver.findElement(By.xpath("(//span[@class='a-size-base a-color-base inline-twister-dim-title-value a-text-bold'])[1]")).getText() + " " + "Price : " + driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText() + "," + driver.findElement(By.xpath("//span[@class='a-price-fraction']")).getText() + "TL");
                System.out.println("Stock: " + driver.findElement(By.xpath("//div[@id='availability']")).getText());
                System.out.println("---------------------------------------------------------------------------------------");
                Thread.sleep(5000);
            }

        }else {
            WebElement list0 = driver.findElement(By.id("size_name_0"));
            list0.click();
            //Log the following values for each size
            //.Size information .Price .Color .Stock status
            System.out.println(driver.findElement(By.id("productTitle")).getText() + " " + "Size : " + driver.findElement(By.xpath("(//span[@class='selection'])[1]")).getText());
            System.out.println("Color: " + driver.findElement(By.xpath("(//span[@class='selection'])[2]")).getText() + " " + "Price : " + driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText() + "," + driver.findElement(By.xpath("//span[@class='a-price-fraction']")).getText() + "TL");
            System.out.println("Stock: " + driver.findElement(By.xpath("//div[@id='availability']")).getText());
            System.out.println("---------------------------------------------------------------------------------------");
            WebElement list1 = driver.findElement(By.id("size_name_1"));
            list1.click();
            //Log the following values for each size
            //.Size information .Price .Color .Stock status
            System.out.println(driver.findElement(By.id("productTitle")).getText() + " " + "Size : " + driver.findElement(By.xpath("(//span[@class='selection'])[1]")).getText());
            System.out.println("Color: " + driver.findElement(By.xpath("(//span[@class='selection'])[2]")).getText() + " " + "Price : " + driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText() + "," + driver.findElement(By.xpath("//span[@class='a-price-fraction']")).getText() + "TL");
            System.out.println("Stock: " + driver.findElement(By.xpath("//div[@id='availability']")).getText());
            System.out.println("---------------------------------------------------------------------------------------");
            WebElement list2 = driver.findElement(By.id("size_name_2"));
            list2.click();
            //Log the following values for each size
            //.Size information .Price .Color .Stock status
            System.out.println(driver.findElement(By.id("productTitle")).getText() + " " + "Size : " + driver.findElement(By.xpath("(//span[@class='selection'])[1]")).getText());
            System.out.println("Color: " + driver.findElement(By.xpath("(//span[@class='selection'])[2]")).getText() + " " + "Price : " + driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText() + "," + driver.findElement(By.xpath("//span[@class='a-price-fraction']")).getText() + "TL");
            System.out.println("Stock: " + driver.findElement(By.xpath("//div[@id='availability']")).getText());

        }
    }
}
