package com.veeva.assignment.stepDefinitions;

import com.veeva.assignment.ApplicationManager.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BasePageStepDefinitions extends DriverManager {


    @Given("Navigate to NBA Warriors Application")
    public void navigate_to_nba_application(){

        openBrowser();
        launchApp();

    }

    @Then("Traverse to \"Shop~Men's\" Menu")
    public void navigate_to_jacket_menu(){

        homePage.navigate_to_menu();
        homePage.switch_to_window();
    }

    @Then("Store Data in Json File")
    public void store_data_in_file(DataTable dataTable){
        List<String> get_jacket_price = new ArrayList<>();
        List<String> get_message_details = new ArrayList<>();

        List<WebElement> priceList = driver().findElements(homePage.jacket_price);
        for(WebElement ele : priceList){
            get_jacket_price.add(ele.getAttribute("innerText"));
        }
        List<WebElement> message_details = driver().findElements(homePage.jacket_tile);
        for(WebElement ele : message_details){
            get_message_details.add(ele.getAttribute("innerText"));
        }


    }

}
