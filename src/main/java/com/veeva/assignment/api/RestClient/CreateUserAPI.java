package com.veeva.assignment.api.RestClient;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class CreateUserAPI extends BaseRestAPIClient{

    public Response create_new_product_api_request(HashMap<Object,Object> dataMap, LinkedHashMap<String,String> headerMap){


        return httpRequest.
                baseUri(factoryManager.getInputProperty("base_api_url")).
                headers(getHeaders(headerMap)).
                   body(dataMap)
                      .when()
                         .post(String.valueOf(dataMap.get("post_api_user")));

    }
}
