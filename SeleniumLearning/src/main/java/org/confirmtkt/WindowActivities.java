package org.confirmtkt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WindowActivities {
    public static void main(String[] args){

        // invoking chrome browser
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chaithra\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe"); // this feature is
        // optional in 4.6.0 version will the help of SeleniumManager in Beta Phase
        // Create WebDriver instance
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
//        driver.get("http://google.com"); // waits until all componets are fully downloaded
//        driver.navigate().to("https://rahulshettyacademy.com");
//        driver.navigate().back();
//        driver.navigate().forward();

        // handling static dropdowns and dynamic dropdowns
        // static dropdowns (mostly select tag)
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        WebElement staticDropdown = driver.findElement((By.id("ctl00_mainContent_DropDownListCurrency")));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(3);
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("AED");
        dropdown.selectByValue("INR"); // html attribute value




    }
}
