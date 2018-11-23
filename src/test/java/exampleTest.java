import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static io.trueautomation.client.TrueAutomationHelper.ta;

public class exampleTest extends BaseTest{
    private By loginBtn = By.cssSelector(ta("ta:mainPage:loginBtn", "a.login-btn"));
    private By signupBtn = By.cssSelector(ta("ta:mainPage:signupBtn", "div.sign-up-container > a"));
    private By emailFl = By.name(ta("ta:loginPage:email", "email"));

    @Test
    public void exampleTest() throws InterruptedException {
        driver.get("https://trueautomation.io");
        Thread.sleep(1000);
        driver.findElement(loginBtn).click();
        Thread.sleep(1000);
        driver.findElement(signupBtn).click();
        Thread.sleep(1000);
        driver.findElement(emailFl).sendKeys("your@mail.com");
        Thread.sleep(1000);
    }

}