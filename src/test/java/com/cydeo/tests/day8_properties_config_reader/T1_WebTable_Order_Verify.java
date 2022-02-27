package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebTablesUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_WebTable_Order_Verify {
    public WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/web-tables");
    }

@AfterMethod
public void tearDownMethod(){
        driver.close();
}

    @Test
    public void order_name_verify_test(){
        //2. Verify Bob’s name is listed as expected.
        //Expected: “Bob Martin”
        WebElement bobMartinCell= driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']"));
         String expectedResult="Bob Martin";
         String actualResult=bobMartinCell.getText();
        Assert.assertEquals(actualResult,expectedResult);



        //3. Verify Bob Martin’s order date is as expected
        //Expected: 12/31/2021

       //Todo: 1 way===> WebElement bobDateCell= driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']/../td[5]"));
      WebElement bobDateCell= driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']/following-sibling::td[3]"));

        String expectedDate="12/31/2021";
         Assert.assertEquals(expectedDate,bobDateCell.getText());
    }





    @Test
    public void test2(){
       String customerOrderDate1= WebTablesUtils.returnOrderDate(driver,"Samuel Jackson");
        String expectedResult="12/21/2021";
        Assert.assertEquals(expectedResult,customerOrderDate1);
    }
      @Test
    public void test3(){
        WebTablesUtils.orderVerify(driver,"Bart Fisher","01/16/2021");
    }



}
