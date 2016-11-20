package ua.stqa.training.selenium;

/**
 * Created by Alexander on 11/19/2016.
 */
import org.junit.Test;
import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class FirstTest extends TestBase {

    @Test
    public void FirstTest() {
        driver.navigate().to("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("btnG")).click();
        wait.until(titleIs("webdriver - "));
    }



}