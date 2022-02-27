package com.cydeo.tests.day6_alert_iframe_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropDownPractices {

    public  WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        //  2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");
    }







    @Test
    public void dropdown_task5() throws InterruptedException {

        Select stateDropdown=new Select(driver.findElement(By.xpath("//select[@id='state']")));
       //  3. Select Illinois
        Thread.sleep(1000);
        stateDropdown.selectByVisibleText("Illinois");
        //   4. Select Virginia
        stateDropdown.selectByValue("VA");
       // 5. Select California
        stateDropdown.selectByIndex(5);
       // 6. Verify final selected option is California.
        String expectedOptionText="California";
         String actualOptionText=stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOptionText,expectedOptionText);

    }

    @Test
    public void dropdown_task6() throws InterruptedException {

        //3. Select “December 1st, 1923” and verify it is selected.
        //Select year using  : visible text
        Select yearDropDown=new Select(driver.findElement(By.xpath("//select[@id='year']")));
         yearDropDown.selectByVisibleText("1923");
         Thread.sleep(1000);
        //Select month using   : value attribute
        Select monthDropDown=new Select(driver.findElement(By.xpath("//select[@id='month']")));
           monthDropDown.selectByValue("11");
        Thread.sleep(1000);
        //Select day using : index number
        Select dayDropDown=new Select(driver.findElement(By.xpath("//select[@id='day']")));
           dayDropDown.selectByIndex(0);
        Thread.sleep(1000);

        String expectedYear="1923";
        String expectedMonth="December";
        String expectedDay="1";
        //getting actual values from browser
        String actualYear=yearDropDown.getFirstSelectedOption().getText();
        String actualMonth=monthDropDown.getFirstSelectedOption().getText();
        String actualDay=dayDropDown.getFirstSelectedOption().getText();

      //create assertions
       Assert.assertTrue(actualYear.equals(expectedYear));
        Assert.assertEquals(actualMonth,expectedMonth);
        Assert.assertEquals(actualDay,expectedDay);
    }


@AfterMethod
    public void teardownMethod(){
        driver.close();
}


}
