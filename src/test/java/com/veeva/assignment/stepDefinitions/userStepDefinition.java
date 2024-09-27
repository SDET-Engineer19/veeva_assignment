package com.veeva.assignment.stepDefinitions;

import com.veeva.assignment.api.RestClient.BaseRestAPIClient;
import com.veeva.assignment.api.RestClient.CreateUserAPI;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class userStepDefinition extends BaseRestAPIClient {

    @Given("Create New User")
    public void create_new_user(DataTable dataTable){

        dataMap.put("name",dataTable.asMap().get("Name"));
        dataMap.put("job", dataTable.asMap().get("Job"));


        headerMap.put("Content-Type","application/json");
        headerMap.put("access-token",access_token);

        CreateUserAPI new_user = new CreateUserAPI();

        new_user.create_new_product_api_request(dataMap,headerMap);

    }

    @Then("Validate \"(.*)\" and \"(.*)\"")
    public void validate_user_details(String statusCode, int time, String name, String job){

        dataMap.put("name",name);
        dataMap.put("job",job);


        headerMap.put("Content-Type","application/json");
        headerMap.put("access-token",access_token);

        CreateUserAPI new_user = new CreateUserAPI();

        response = new_user.create_new_product_api_request(dataMap,headerMap);
       // Assert.assertEquals(response.getStatusCode(),statusCode);
        //Assert.assertEquals(response.getTime(),time);
        //Assert.assertEquals(jsonPath.read("\"name\""),dataMap.get("name"));
        //Assert.assertEquals(jsonPath.read("\"job\""),dataMap.get("job"));



    }
}
