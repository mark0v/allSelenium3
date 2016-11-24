package ua.stqa.training.selenium.litecart.loginTest;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.stqa.training.selenium.TestBase;
import org.junit.Assert;
import java.util.*;

/**
 * Created by Alexander on 11/22/2016.
 */
public class mainMenueOpenPages extends TestBase{



    @Test
    public void  clickByAllMenueItems(){
        loginAsAdmin();
        List<String> names = getNameListItems();
        for(String name : names){
            if(!isMenueSelected(name)){
                clickMenueByName(name);
                Assert.assertTrue(isElementPresent(By.xpath(".//*[@id='content']/h1")));
                System.out.println("Click by MENUE: " + name);
                clickingSubMenue(name);
            }
        }
    }

    public List<String > getNameListItems(){
        List<WebElement> listWebEl = driver.findElements(By.xpath(".//*[@id='box-apps-menu-wrapper']//li"));
        ArrayList<String > listNames = new ArrayList<>();
        for(WebElement el : listWebEl){
            listNames.add(el.getText());
        }
        return listNames;
     }

    public boolean isMenueSelected(String menue){
        return driver.findElement(By.xpath(".//li[contains(.,'"+ menue +"')]")).isSelected();
    }

    public void clickingSubMenue(String MenueName){
        int size = driver.findElements(By.xpath(".//li[contains(.,'"+ MenueName +"')]/ul/li")).size();
        int index = 1;
        for (int i = 0; i < size; i++) {
            driver.findElement(By.xpath(".//li[contains(.,'"+ MenueName +"')]/ul/li["+ index +"]")).click();
            String subMenueName = driver.findElement(By.xpath(".//li[contains(.,'"+ MenueName +"')]/ul/li["+ index +"]")).getText();
            System.out.println("Click by SubMenue: " + subMenueName);
            index++;
            Assert.assertTrue(isElementPresent(By.xpath(".//*[@id='content']/h1")));
        }
        System.out.println("-----------------------------");
    }

    public void clickMenueByName(String nameMenue){
        driver.findElement(By.xpath("//a[contains(.,'"+ nameMenue +"')]")).click();
    }

    public boolean isElementPresent(By by){
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException ex){return false;}
    }
}
