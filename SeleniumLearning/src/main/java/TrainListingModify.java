import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TrainListingModify {

    public static void main(String[] args) throws Exception {


        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 375);
        deviceMetrics.put("height", 812);
        deviceMetrics.put("pixelRatio", 3.0);

        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);
        mobileEmulation.put("userAgent",
                "Mozilla/5.0 (iPhone; CPU iPhone OS 13_2 like Mac OS X) "
                        + "AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0 Mobile/15E148 Safari/604.1");

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("mobileEmulation", mobileEmulation);

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://www.confirmtkt.com/");
        Thread.sleep(3000);


        WebElement searchBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("searchtrains"))
        );
        js.executeScript("arguments[0].click();", searchBtn);
        Thread.sleep(2000);


        By modifyRow = By.xpath("//div[contains(@class,'flex') and .//p[text()='NDLS']]");
        WebElement modifyElement = wait.until(
                ExpectedConditions.elementToBeClickable(modifyRow)
        );
        js.executeScript("arguments[0].click();", modifyElement);
        Thread.sleep(2000);


        By enterFrom = By.xpath("//p[.//span[text()='Enter From']]");
        WebElement enterFromElement = wait.until(
                ExpectedConditions.elementToBeClickable(enterFrom)
        );
        js.executeScript("arguments[0].click();", enterFromElement);
        Thread.sleep(1500);


        By searchBox = By.xpath("//input[@placeholder='Search for a station/city']");
        WebElement fromSearch = wait.until(
                ExpectedConditions.visibilityOfElementLocated(searchBox)
        );
        fromSearch.sendKeys("Anantapur");
        Thread.sleep(2000);


        By atpOption = By.xpath("//p[contains(text(),'ATP')]");
        WebElement atpElement = wait.until(
                ExpectedConditions.elementToBeClickable(atpOption)
        );
        js.executeScript("arguments[0].click();", atpElement);
        Thread.sleep(1500);


        By enterTo = By.xpath("//p[.//span[text()='Enter To']]");
        WebElement enterToElement = wait.until(
                ExpectedConditions.elementToBeClickable(enterTo)
        );
        js.executeScript("arguments[0].click();", enterToElement);
        Thread.sleep(1500);

        WebElement toSearch = wait.until(
                ExpectedConditions.visibilityOfElementLocated(searchBox)
        );
        toSearch.sendKeys("Bangalore");
        Thread.sleep(2000);


        By sbcOption = By.xpath("//p[contains(text(),'SBC') or contains(text(),'Bengaluru')]");
        WebElement sbcElement = wait.until(
                ExpectedConditions.elementToBeClickable(sbcOption)
        );
        js.executeScript("arguments[0].click();", sbcElement);
        Thread.sleep(1500);


        By backArrow = By.xpath("//svg[@data-testid='ArrowLeftIcon']");
        WebElement backArrowElement = wait.until(
                ExpectedConditions.elementToBeClickable(backArrow)
        );
        js.executeScript("arguments[0].click();", backArrowElement);
        Thread.sleep(2000);


        By finalSearch = By.xpath("//button[contains(text(),'SEARCH TRAINS')]");
        WebElement finalSearchBtn = wait.until(
                ExpectedConditions.elementToBeClickable(finalSearch)
        );
        js.executeScript("arguments[0].click();", finalSearchBtn);
        Thread.sleep(2500);

        By bottomSearch = By.xpath("//button[contains(text(),'SEARCH TRAINS')]");
        WebElement bottomSearchBtn = wait.until(
                ExpectedConditions.elementToBeClickable(bottomSearch)
        );
        js.executeScript("arguments[0].click();", bottomSearchBtn);

        System.out.println(" FULL AUTOMATION COMPLETE — Browser left OPEN.");
    }
}
