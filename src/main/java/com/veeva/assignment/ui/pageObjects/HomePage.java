package com.veeva.assignment.ui.pageObjects;

import com.veeva.assignment.ApplicationManager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HomePage extends DriverManager {

    public By menu_locator = By.xpath("//li[@class='menu-item']//span[normalize-space()='Shop']");
    public By sub_menu = By.xpath("//li[@role='menuitem']//a[contains(@title,'Men's')]");
    public By jacket_price = By.xpath("//span[@class='sr-only']//parent::span[@class='money-value']");
    public By jacket_tile = By.xpath("//div[@class='product-card-title']//a");


    public void navigate_to_menu(){

        try{
             driver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
             boolean flag = getWebElement(menu_locator).isDisplayed();
             if(flag){
                 Actions actions = new Actions(driver());
                 actions.moveToElement(getWebElement(menu_locator)).click().build().perform();
                 getWebElement(sub_menu).click();
             }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void switch_to_window(){

        String parent_window_id = "";
        String child_window_id = "";
        String parent_window_title = driver().getTitle();

        Set<String> handles = new HashSet<>();
        handles = driver().getWindowHandles();
        Iterator<String> handle_window = handles.iterator();
        parent_window_id = handle_window.next();
        child_window_id = handle_window.next();

        if(!parent_window_title.equals(driver().getTitle()) && !parent_window_id.equals(child_window_id)){

            driver().switchTo().window(child_window_id);
        }
        else {
            driver().switchTo().defaultContent();
        }
    }
}
