package org.confirmtkt;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;

import java.time.Duration;

public class Locators2 {

    public static void main(String[] args) throws InterruptedException{

        // Set path to ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chaithra\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Create WebDriver instance
        WebDriver driver = new ChromeDriver();

//        // Set implicit wait
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        String password = getPassword(driver);
//
//        // Navigate to website
//        driver.get("https://rahulshettyacademy.com/locatorspractice/");
//
//        // Perform actions
//        driver.findElement(By.id("inputUsername")).sendKeys("chitti");
//        driver.findElement(By.name("inputPassword")).sendKeys(password);
//        driver.findElement(By.className("signInBtn")).click();
//
//        // Validate success login
//        String actualMessage = driver.findElement(By.tagName("p")).getText();
//        Thread.sleep(2000);
//        System.out.println("Login Message: " + actualMessage);
////        Assert.assertEquals(actualMessage, "You are successfully logged in.");
////        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello chitti,"));
////        driver.findElement(By.xpath("/*[text()='Log Out")).click();
////        driver.close();
//
//
//    }
//
//    public static String getPassword(WebDriver driver) throws InterruptedException {
//        driver.get("https://rahulshettyacademy.com/locatorspractice/");
//        driver.findElement(By.linkText("Forgot your password?")).click();
//        Thread.sleep(1000);
//        driver.findElement(new By.ByCssSelector(".reset-pwd-btn")).click();
//        String passwordText = driver.findElement(By.cssSelector("form p")).getText();
//        String[] passwordArray = passwordText.split("'");
//        String[] passwordArray2 = passwordArray[1].split("'");
////        passwordArray2[0]
//        String password = passwordArray[1].split("'")[0];
//        return  password;
//
//        //https://rahulshettyacademy.com/AutomationPractice/

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
       System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::buttton[1]")).getText());

       // traverse from child to parent elements it is possible in xPath
        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());


    }

}
