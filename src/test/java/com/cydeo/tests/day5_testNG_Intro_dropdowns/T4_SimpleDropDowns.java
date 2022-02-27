package com.cydeo.tests.day5_testNG_Intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_SimpleDropDowns {

    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        //Do browser driver setup
        //open browser
         driver= WebDriverFactory.getDriver("chrome");

        //maximize the page
        driver.manage().window().maximize();
        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);

    }
@Test
public void simpleDropDownTest(){
    //  2. Go to https://practice.cydeo.com/dropdown
    driver.get("https://practice.cydeo.com/dropdown");
    // 3. Verify “Simple dropdown” default selected value is correct
    Select simpleDropdown=new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
    // Expected: “Please select an option”

     WebElement currentlySelectedOption= simpleDropdown.getFirstSelectedOption();

     String actualSimpleDropdownText= currentlySelectedOption.getText();
     String expectedSimpleDropdownText="Please select an option";

    Assert.assertEquals(actualSimpleDropdownText,expectedSimpleDropdownText);

    // 4. Verify “State selection” default selected value is correct
    //    Expected: “Select a State”


      Select stateDropdown=new Select(driver.findElement(By.xpath("//select[@id='state']")));
          String actualStateDropdown="Select a State";
         String expectedStateDropdown= stateDropdown.getFirstSelectedOption().getText();
           //TODO:IKISI DE AYNI SEYI YAPIYOR
           Assert.assertEquals(actualStateDropdown,expectedStateDropdown);
         // Assert.assertEquals(stateDropdown.getFirstSelectedOption().getText(),"Select a State");

}










}
