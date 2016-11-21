package ua.stqa.training.selenium.RunBrowsers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alexander on 11/21/2016.
 */
public class chromeAlt {
    private WebDriverWait wait;
    ChromeOptions options = new ChromeOptions();
    WebDriver driver = new ChromeDriver(options);

    @Before
    public void start(){
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        options.addArguments("start-maximized");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void runChrome(){
        driver.navigate().to("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("btnG")).click();
        // wait.until(titleIs("webdriver - Пошук Google"));
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
