package org.confirmtkt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutoSuggestions {
    public static void main(String[] args) throws InterruptedException {
        // Set path to ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chaithra\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Create WebDriver instance
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(3000);
        List<WebElement> options = (List<WebElement>) driver.findElement(By.cssSelector("li[class='ui-menu-item]a"));

        for(WebElement option: options){
            if(option.getText().equalsIgnoreCase("India")){
                option.click();
                break; // ends here
            }
        }

    }
}
