package ex3_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Ex2 {

    /*
    Asagidaki testi text’leri kullanarak locate edin
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

        WebElement addElementButton = driver.findElement(By.xpath("//button[.='Add Element']"));
        addElementButton.click();
        Thread.sleep(2000);
        WebElement deleteButton = driver.findElement(By.xpath("//button[.='Delete']"));

        if (deleteButton.isDisplayed()) {
            System.out.println("Delete butonu testi PASSED");
        } else {
            System.out.println("Delete butonu testi FAILED");
        }

        deleteButton.click();
        Thread.sleep(2000);

        WebElement addRemoveElementYazisi = driver.findElement(By.xpath("//*[.='Add/Remove Elements']"));

        if (addRemoveElementYazisi.isDisplayed()) {
            System.out.println("Add/Remove yazisi testi PASSED");
        } else {
            System.out.println("Add/Remove yazisi testi FAILED");
        }

    }
}
