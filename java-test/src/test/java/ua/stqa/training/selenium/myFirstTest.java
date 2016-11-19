package ua.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by Alexander on 11/19/2016.
 */
public class myFirstTest extends TestBase{
    @Test
    public void myFirstTest() {
        driver.navigate().to("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("btnG")).click();
       // wait.until(titleIs("webdriver - Поиск в Google"));
    }
}
