package org.confirmtkt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dropdown {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chaithra\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Create WebDriver instance
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1")).click();

        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
    }
}
