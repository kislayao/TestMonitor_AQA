package services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.configuration.ReadProperties;

import java.time.Duration;


public class WaitService {
    private WebDriverWait wait;
    private WebDriver driver;

    public WaitService(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(ReadProperties.timeout()));
    }

}
