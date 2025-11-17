package org.confirmtkt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatorsEx {
    public static void main(String[] args) throws InterruptedException {

        // implicit weight
        // seconds of time it will wait until msg is dispalyed

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chaithra\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("chitti");
        driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
        driver.findElement(By.className("signInBtn")).click();

        // css selector if id or class is not there
        // tagname.classname -> Button.signInBtn
//        id -> tagname#id -> input#inputUsername
//        Tagname[attribute="value"]

        // printing the error msg displayed on the screen
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        driver.findElement(By.linkText("Forgot your password")).click();
//        Thread.sleep(1000);

        // xpath and css selctors are generic selectors
        // tagname[@attribute='value']
        //input[@placeholder

//        driver.findElement(By.ByCssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");
//        // to clear the edit box
//        driver.findElement(By.ByCssSelector("input[placeholder='Email'][2]")).clear();
//        driver.findElement(By.ByCssSelector("input[placeholder='Email']")).sendKeys("john@gmail.com");


        // input[@type = 'text'][2] -> when multiple elements are matching
        // using x path, we can travel from parent tags to child tags
        // by using -> /
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("7981233212");
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());
        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-container']/button[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("chitti");
        // using regular expressions
        // password -> pass is static, word will keep on changing
        // use '*' as regular expression (partial text)
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("chkboxOne")).click();
        // re using xpath -> //button[contains(@class, 'submit)]
        driver.findElement(By.xpath("//button[contains(@class, 'submit')]")).click();






    }
}
