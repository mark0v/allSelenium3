package ua.stqa.training.selenium.RunBrowsers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Created by Alexander on 11/21/2016.
 */
public class fireFoxNightly {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start(){
        DesiredCapabilities caps = new DesiredCapabilities();
        driver = new FirefoxDriver(
                new FirefoxBinary(new File("C:\\Program Files (x86)\\Nightly\\firefox.exe")),
                new FirefoxProfile(), caps);
        System.out.println(((HasCapabilities) driver).getCapabilities());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void runFireFoxNightly(){
        driver.navigate().to("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("btnG")).click();
        //wait.until(titleIs("webdriver - Пошук Google"));
    }
    @Test
    public void loginAsAdminNightly(){
        driver.navigate().to("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        wait.until(presenceOfElementLocated(By.cssSelector(".fa.fa-sign-out.fa-lg")));
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
