package services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.configuration.ReadProperties;

import java.time.Duration;
import java.util.List;


public class WaitService {
    private WebDriverWait wait;
    private WebDriver driver;

    public WaitService(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(ReadProperties.timeout()));
    }

    public WebElement waitForVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForVisibilityLocatedBy(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> waitForAllVisibleElementsLocatedBy(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public Boolean waitForElementInvisible(WebElement element) {
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }
}
