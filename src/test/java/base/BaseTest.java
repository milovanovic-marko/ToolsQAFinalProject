package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public WebDriverWait wait;
    public ExcelReader excelReader;
    public String homeUrl;
    public Actions act;
    public JavascriptExecutor js;

    @BeforeClass
    public void setUp() throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("load-extension=" + System.getProperty("user.dir") + "\\src\\test\\resources\\1.50.0_0");
        driver = new ChromeDriver(options);

        act = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        excelReader = new ExcelReader("src/test/resources/TestData.xlsx");
        homeUrl = excelReader.getStringData("URL", 1, 0);
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    public void scrollIntoView(WebElement element) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void waitForUrl(String url) {
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForInvisibility(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean elementIsPresent(WebElement element) {
        boolean nonExistingElement = false;
        try {
            nonExistingElement = element.isDisplayed();
        } catch (Exception e) {

        }
        return nonExistingElement;
    }

    public void doubleClick(WebElement element) {
        act.doubleClick(element).perform();
    }

    public void rightClick(WebElement element) {
        act.contextClick(element).perform();
    }

    public void openNewTab() {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
    }

    public String getColourFromElement (WebElement element, String propertyColour) {
        return element.getCssValue(propertyColour);
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    @AfterClass
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
