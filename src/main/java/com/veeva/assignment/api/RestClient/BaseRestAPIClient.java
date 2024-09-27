package com.veeva.assignment.api.RestClient;

import com.jayway.jsonpath.JsonPath;
import com.veeva.assignment.ApplicationManager.FactoryManager;
import com.veeva.assignment.api.Constants.constant;
import com.veeva.assignment.api.RequestEndpoints.RequestEndPoints;
import com.veeva.assignment.ui.utility.utils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class BaseRestAPIClient {


        protected static RequestSpecification httpRequest;
        protected static RequestSpecification authenticate;
        protected static RequestEndPoints endPoints;
        protected static constant con;
        protected static JsonPath jsonPath;
        protected static Response response;
        protected static String access_token = null;
        protected static utils utility = null;
        protected static HashMap<Object,Object> dataMap = new HashMap<Object,Object>();
        protected static LinkedHashMap<String,String> headerMap = new LinkedHashMap<String,String>();
        protected static FactoryManager factoryManager = null;

        public void setPrerequisiteAPI() {

            factoryManager = new FactoryManager();
            endPoints = new RequestEndPoints();
            con = new constant();
            utility = new utils();

        }

        public RequestSpecification setRequest() {

            return RestAssured.given();
        }



        public LinkedHashMap<String, String> getHeaders(LinkedHashMap<String,String> data){

            LinkedHashMap<String,String> headerMap = new LinkedHashMap<String,String>();
            headerMap.put("Content-Type",data.get("Content-Type"));
            headerMap.put("access_token",data.get("access_token"));

            return headerMap;
        }




    }
