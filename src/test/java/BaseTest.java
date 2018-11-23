import io.trueautomation.client.driver.TrueAutomationDriver;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    TrueAutomationDriver driver;

    @Parameters(value = {"browser"})
    @BeforeTest(alwaysRun = true)
    public void beforeTest (String browser) throws MalformedURLException {
        MutableCapabilities capabilities = new MutableCapabilities();

        if (browser.equals("FF")) {
            capabilities = new FirefoxOptions();
        } else if (browser.equals("CHROME")) {
            capabilities = new ChromeOptions();
        } else if (browser.equals("SAFARI")) {
            capabilities = new SafariOptions();
        } else if (browser.equals("EDGE")) {
            capabilities = new EdgeOptions();
        } else if (browser.equals("IE")) {
            capabilities = new InternetExplorerOptions();
        } else {
            capabilities.setCapability("browserName", browser);
        }

        driver = new TrueAutomationDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}