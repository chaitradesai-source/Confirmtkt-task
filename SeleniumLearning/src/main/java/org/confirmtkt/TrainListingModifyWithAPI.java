import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TrainListingModifyWithAPI {

    public static void main(String[] args) {

        try {

            Map<String, Object> deviceMetrics = new HashMap<>();
            deviceMetrics.put("width", 375);
            deviceMetrics.put("height", 812);
            deviceMetrics.put("pixelRatio", 3.0);

            Map<String, Object> mobileEmulation = new HashMap<>();
            mobileEmulation.put("deviceMetrics", deviceMetrics);
            mobileEmulation.put("userAgent",
                    "Mozilla/5.0 (iPhone; CPU iPhone OS 13_2 like Mac OS X) " +
                            "AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0 Mobile/15E148 Safari/604.1");

            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("mobileEmulation", mobileEmulation);

            WebDriver driver = new ChromeDriver(options);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
            JavascriptExecutor js = (JavascriptExecutor) driver;

            driver.get("https://www.confirmtkt.com/");
            Thread.sleep(3000);

            WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("searchtrains")));
            js.executeScript("arguments[0].click();", searchBtn);
            Thread.sleep(2000);

            try {
                By modifyRow = By.xpath("//div[contains(@class,'flex') and .//p[text()='NDLS']]");
                WebElement modifyElement = wait.until(ExpectedConditions.elementToBeClickable(modifyRow));
                js.executeScript("arguments[0].click();", modifyElement);
                Thread.sleep(2000);
            } catch (Exception e) {}

            selectStation(driver, wait, js, "Enter From", "ATP", "Anantapur");
            selectStation(driver, wait, js, "Enter To", "SBC", "Bengaluru");

            try {
                By backArrow = By.xpath("//svg[@data-testid='ArrowLeftIcon']");
                WebElement backArrowElement = wait.until(ExpectedConditions.elementToBeClickable(backArrow));
                js.executeScript("arguments[0].click();", backArrowElement);
                Thread.sleep(2000);
            } catch (Exception e) {}

            By finalSearch = By.xpath("//button[contains(text(),'SEARCH TRAINS')]");
            WebElement finalSearchBtn = wait.until(ExpectedConditions.elementToBeClickable(finalSearch));
            js.executeScript("arguments[0].click();", finalSearchBtn);
            Thread.sleep(2000);

            By bottomSearch = By.xpath("//button[contains(text(),'SEARCH TRAINS')]");
            WebElement bottomSearchBtn = wait.until(ExpectedConditions.elementToBeClickable(bottomSearch));
            js.executeScript("arguments[0].click();", bottomSearchBtn);

            System.out.println("FULL AUTOMATION COMPLETE — Browser left OPEN.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void selectStation(WebDriver driver, WebDriverWait wait, JavascriptExecutor js,
                                      String fieldLabel, String stationCode, String stationName) throws InterruptedException {

        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//p[.//span[text()='" + fieldLabel + "']]")));
        js.executeScript("arguments[0].scrollIntoView(true);", field);
        js.executeScript("arguments[0].click();", field);

        WebElement inputBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Search for a station/city']")));
        inputBox.clear();
        inputBox.sendKeys(stationName);
        Thread.sleep(2000);

        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[contains(normalize-space(text()),'" + stationCode + "')]")));
        js.executeScript("arguments[0].scrollIntoView(true);", option);
        js.executeScript("arguments[0].click();", option);
        Thread.sleep(1000);
    }
}
