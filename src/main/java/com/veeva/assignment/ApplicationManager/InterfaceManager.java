package com.veeva.assignment.ApplicationManager;

import org.openqa.selenium.By;

public interface InterfaceManager {

    public abstract void clickBtnElement(By locator);

    public abstract void enterTextAndClick(By locator,String input) ;

    public abstract String validatePageTitle(String title);
}
