package com.cydeo.tests.day6_alert_iframe_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_IframePractice {
    WebDriver driver ;
   // @BeforeMethod
    @BeforeClass
    public void  setupMethod() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        ////3. Go to: https://practice.cydeo.com/iframe
        driver.get("http://practice.cydeo.com/iframe");
    }


    @Test
    public void iframe_Test(){

        //We need switch driver's focus to iframe
        //option 1 switching to iframe using id attribute value
        //driver.switchTo().frame("mce_0_ifr");

        //option 2 -passing index number of iframe
       // driver.switchTo().frame(0);

        //option 3 -locate as web element and pass in frame () method
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));



        //Locate the p tag
        WebElement yourContentGoesHereText= driver.findElement(By.xpath("//p"));
        //4. Assert: “Your content goes here.” Text is displayed.
       Assert.assertTrue(yourContentGoesHereText.isDisplayed());

       //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
      //to be able to verify the header,wemust switch back to "main HTML"
          driver.switchTo().parentFrame();
         WebElement headerText=driver.findElement(By.xpath("//h3"));
          //  String expectedHeader="An iFrame containing the TinyMCE WYSIWYG Editor";
          //String actualHeader=headerText.getText();

          //assertion of header text displayed or not
           Assert.assertTrue(headerText.isDisplayed());


    }






//5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”







}
