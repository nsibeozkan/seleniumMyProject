package com.cydeo.tests.day5_testNG_Intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNG_Selenium {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        //Do browser driver setup
        //open browser
       driver= WebDriverFactory.getDriver("chrome");

        //maximize the page
        driver.manage().window().maximize();

        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }


    @Test
      public void selenium_test(){



          //get"https://www.google.com"

          driver.get("https://www.google.com");
          String actualTitle= driver.getTitle();
          String expectedTitle="Google";
          //ASSERT:title is "Google"
          Assert.assertEquals(actualTitle,expectedTitle,"Title is not matching here");
    }




}
