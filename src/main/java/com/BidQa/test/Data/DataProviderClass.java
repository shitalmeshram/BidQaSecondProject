package com.BidQa.test.Data;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

/**
 * Created by hishailesh77 on 5/17/2017.
 */
public class DataProviderClass {
    WebDriver driver;

    //Provides login credentials for 3 QA Engineers
    @DataProvider(name = "ProjectOwnerData")
    public static Object[][] getPoLoginData() {
        // The number of times data is repeated, test will be executed the same no. of times

        // Here it will execute 1 times
        Object[][] data = new Object[1][1];
        // 1st row
        data[0][0]="daniel";
        data[0][1]="mnop";

        return data;
    }
}
