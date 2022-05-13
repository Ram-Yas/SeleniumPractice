package ex3_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Ex1 {

    /*
    1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
    2- Add Element butonuna basin
    3- Delete butonu’nun gorunur oldugunu test edin
    4- Delete tusuna basin
    5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
     */

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //    2- Add Element butonuna basin
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
        Thread.sleep(2000);

        //  4- Delete tusuna basin

        WebElement deleteButonu = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
        if (deleteButonu.isDisplayed()) {
            System.out.println("Delete Butonu testi PASSED");
        } else {
            System.out.println("Delete Butonu yazisi testi FAILED");
        }
        deleteButonu.click();

        Thread.sleep(2000);

        //    5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin

        WebElement addRemoveElementYazisi = driver.findElement(By.xpath("//h3"));
        if (addRemoveElementYazisi.isDisplayed()) {
            System.out.println("Add/Remove yazisi testi PASSED");
        } else {
            System.out.println("Add/Remove yazisi testi FAILED");
        }

        driver.quit();


    }
}
