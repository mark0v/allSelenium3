package ua.stqa.training.selenium;

/**
 * Created by Alexander on 11/20/2016.
 */

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class runerBrowser {

    public WebDriver driver;
    public WebDriverWait wait;


    @Before
    public void start(){
        //wait = new WebDriverWait(driver, 10);

        driver = new ChromeDriver();
       // driver = new InternetExplorerDriver();
        //driver = new FirefoxDriver();
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }

    @Test
    public void runBrowser(){
        //driver.navigate().to("http:////localhost:8080//litecart//admin");
        driver.navigate().to("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("btnG")).click();
        WebElement resultStats = driver.findElement(By.id("resultStats"));
        wait.until(visibilityOf(resultStats));


        //driver.findElement(By.cssSelector("input[name=username]")).sendKeys("admin");
        //driver.findElement(By.cssSelector("input[name=password]")).sendKeys("admin");
        //driver.findElement(By.cssSelector("button[name=login]")).click();

    }



}
