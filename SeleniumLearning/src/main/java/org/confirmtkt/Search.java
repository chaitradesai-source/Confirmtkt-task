import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Search {
    public static void main(String[] args) {
        // Set the path to your ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chaithra\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Open the ConfirmTkt website
            driver.get("https://www.confirmtkt.com/");

            // Wait for 5 seconds for the page to load fully
            Thread.sleep(5000);

            // Click on the Search button
            WebElement searchButton = driver.findElement(By.id("searchtrains"));
            searchButton.click();

            System.out.println("Clicked on Search button. Waiting for results...");

            // Wait for 5 seconds after clicking
            Thread.sleep(5000);

            // Locate the h4 element with the train route text
            WebElement trainHeader = driver.findElement(By.xpath("//h4[contains(@class,'h4') and contains(@class,'mb-5')]"));
            String headerText = trainHeader.getText().trim();

            System.out.println("Header found: " + headerText);

            // Check if both NDLS and MMCT are present in the header
            if (headerText.contains("NDLS") && headerText.contains("MMCT")) {
                System.out.println("Trains are displayed for source as NDLS and destination as MMCT.");
            } else {
                System.out.println("Error: Expected source/destination not found in header text.");
            }

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        } finally {
            // Close the browser after 3 seconds
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ignored) {}
            driver.quit();
        }
    }
}
