package com.veeva.assignment.ui.utility;

import org.apache.commons.lang3.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.*;

public class utils {




        public static String generateRandomString(){

            String value = "Sample_Automation_Product_"+RandomStringUtils.randomAlphabetic(2)+getTimeStamp();
            return value;
        }

        public static String generateRandomInteger(){

            String value = 234+RandomStringUtils.randomNumeric(2);
            return value;
        }

        public static String generateRandomAlphaNumeric(){

            String value = "Sample Automation Product" + RandomStringUtils.randomAlphanumeric(3)+getTimeStamp();
            return value;
        }

        public static String getTimeStamp(){

            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            return timeStamp;
        }
}
