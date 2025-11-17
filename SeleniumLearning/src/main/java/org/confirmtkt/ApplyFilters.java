import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class ApplyFilters {

    public static void main(String[] args) throws Exception {

        //
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://www.confirmtkt.com/");
        Thread.sleep(3000);

        WebElement searchBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("searchtrains"))
        );
        js.executeScript("arguments[0].click();", searchBtn);
        Thread.sleep(2000);

        System.out.println("Search Trains clicked.");

        By checkboxLocator = By.cssSelector("input.absolute.opacity-0.w-full.h-full.inset-0.cursor-pointer");
        WebElement checkbox = wait.until(
                ExpectedConditions.elementToBeClickable(checkboxLocator)
        );


        js.executeScript("arguments[0].click();", checkbox);
        Thread.sleep(1000);

        boolean isChecked = checkbox.isSelected();
        System.out.println(" Checkbox toggled. Current state: " + isChecked);

        System.out.println(" Mobile view automation complete. Browser left open.");
    }
}
