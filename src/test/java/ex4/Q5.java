package ex4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q5 {
     /*
       // ...Exercise5...
       // Navigate to website  https://testpages.herokuapp.com/styled/index.html
       // Under the  ORIGINAL CONTENTS
       // click on Alerts
       // print the URL
       // navigate back
       // print the URL
       // Click on Basic Ajax
       // print the URL
       // enter value-> 20 and Enter
       // and then verify Submitted Values is displayed open page
       // close driver
        */

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // Navigate to website  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        // Under the  ORIGINAL CONTENTS
        // click on Alerts
        driver.findElement(By.xpath("//a[@id='alerts']")).click();

        // print the URL
        System.out.println(driver.getCurrentUrl());
        // navigate back
        driver.navigate().back();
        // print the URL
        System.out.println(driver.getCurrentUrl());
        // Click on Basic Ajax
        driver.findElement(By.xpath("//a[@id='basicajax']")).click();
        // print the URL
        System.out.println(driver.getCurrentUrl());
        // enter value-> 20 and Enter
        driver.findElement(By.id("lteq30")).sendKeys("20" + Keys.ENTER);

        // and then verify Submitted Values is displayed open page
        WebElement submitValues = driver.findElement(By.xpath("//*[.='Submitted Values']"));
        String submitValuesYazisi = submitValues.getText();

        if (submitValues.isDisplayed()) {
            System.out.println("test PASSED");
        } else System.out.println("test FAILED");

        // close driver
        driver.close();
    }


}