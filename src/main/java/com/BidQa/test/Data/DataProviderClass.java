package com.BidQa.test.Data;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

/**
 * Created by hishailesh77 on 5/17/2017.
 */
public class DataProviderClass {
    WebDriver driver;


    @DataProvider(name = "DataCredentials")
    public  Object[][] getPoLoginData(Method m) {
        if (m.getName().equalsIgnoreCase("ProjectOwnerTest")) {
            // The number of times data is repeated, test will be executed the same no. of times
            // Here it will execute 1 times
            return new Object[][]{
                    {"daniel", "mnop"}
            };
        } else if (m.getName().equalsIgnoreCase("QaEngineerTest")) {
            return new Object[][]{
                    {"shaan", "7777"},{"danny","12345"}
            };
        } else {
            System.out.println("No method found");
        };
        return new Object[0][];
    }
    }

