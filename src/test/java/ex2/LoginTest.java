package ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class LoginTest {

    /*
    1. Bir class oluşturun: LoginTest
    2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
        a. http://a.testaddressbook.com adresine gidiniz.
        b. Sign in butonuna basin
        c. email textbox,password textbox, and signin button elementlerini locate ediniz..
        d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
            i. Username : testtechproed@gmail.com
            ii. Password : Test1234!
        e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
        f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
    3. Sayfada kac tane link oldugunu bulun.
     */

    public static void main(String[] args) {

        //1. Bir class oluşturun: LoginTest
        //    2. Main method oluşturun ve aşağıdaki görevi tamamlayın.


        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //        a. http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");
        //        b. Sign in butonuna basin
        WebElement signInLink = driver.findElement(By.id("sign-in"));
        signInLink.click();

        //        c. email textbox,password textbox, and signin button elementlerini locate ediniz..
        WebElement emailTextBox = driver.findElement(By.name("session[email]"));
        WebElement passwordTextBox = driver.findElement(By.name("session[password]"));
        WebElement signInButton = driver.findElement(By.name("commit"));

        //        d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
        //            i. Username : testtechproed@gmail.com
        //            ii. Password : Test1234!
        emailTextBox.sendKeys("testtechproed@gmail.com");
        passwordTextBox.sendKeys("Test1234!");
        signInButton.click();

        //        e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
        WebElement actualUserId = driver.findElement(By.className("navbar-text"));
        String expextedUserEmail = "testtechproed@gmail.com";
        if (expextedUserEmail.equals(actualUserId)) {
            System.out.println(expextedUserEmail + " test PASSED");
        } else {
            System.out.println(expextedUserEmail + " test FAILED");
        }
        //        f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
        WebElement adressesElement = driver.findElement(By.linkText("Addresses"));
        WebElement signOutElement = driver.findElement(By.linkText("Sign out"));

        if (adressesElement.isDisplayed()) {
            System.out.println("adresses test PASSED");
        } else {
            System.out.println("adresses test FAILED");
        }

        if (signOutElement.isDisplayed()){
            System.out.println("sign out test PASSED");
        } else {
            System.out.println("sign out test FAILED");
        }
        //    3. Sayfada kac tane link oldugunu bulun.

        List<WebElement> linksOnThePage = driver.findElements(By.tagName("a"));
        System.out.println("sayfadaki link sayisi : " + linksOnThePage.size());

        for (WebElement each : linksOnThePage) {
            System.out.println(each.getText());
        }

        driver.close();
    }

}
