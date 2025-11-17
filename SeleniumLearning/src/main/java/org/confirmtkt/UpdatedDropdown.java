//package org.confirmtkt;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//// TestNG is one of the testing framework
////import org.testng.annotations.Test;
//
//public class UpdatedDropdown {
//    public static void main(String[] args) throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chaithra\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe"); // this feature is
//        WebDriver driver = new ChromeDriver();
//
//        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
//        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount'")).isSelected());
////        Assert.assertFalse(true);
////
////        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount'")).isSelected());
////        Assert.assertEquals();, selenium result and expected result
//        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount'")).click();
//        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount'")).isSelected(); // checks if a checkbox is selecte
//
//        /// count the no of checkboxes
//        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox'")).size());
//        driver.findElement(By.id("divpaxinfo")).click();
//        Thread.sleep(2000L);
//
//
//
//
//
//
//
//
//        driver.findElement(By.id("divpaxinfo")).click();
//        Thread.sleep(2000L);
//
//        int i = 1;
//        while (i < 5){
//            driver.findElement(By.id("hrefIncAdt")).click(); /// how to select multiple times
//
//            i++;
//
//        }
////        driver.findElement(By.id("hrefIncAdt")).click(); /// how to select multiple times
//        driver.findElement(By.id("btnclosepaxoption")).click();
//        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
//
//        // dynamic dropdowns -> to dropdowns will be loaded only when from dropdown option is selected
//        // //a[@value='MAA'] - Xpath for chennai
//        // //a[@value='BLR']
//
//        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1")).click();
////        driver.findElement(By.xpath("//a@value=''"))
//
//    }
//}
