package ua.stqa.training.selenium;

/**
 * Created by Alexander on 11/20/2016.
 */
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class runerBrowser {
    public WebDriver driver;

    @Before
    public void start(){
        driver = new ChromeDriver();
    }

    @After
    public void stop(){
        driver.quit();
        driver.close();
    }

    @Test
    public void runBrowser(){
        driver.navigate().to("http:////localhost:8080//litecart//admin");
        driver.findElement(By.cssSelector("input[name=username]")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[name=login]")).click();

    }



}
