import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BrowserFactory {

    private WebDriver driver = null;


    public WebDriver getDriver() {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));


        return this.driver;
    }

    public ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.setHeadless(false);
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--silent");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--headless=new");

        return chromeOptions;
    }
}
