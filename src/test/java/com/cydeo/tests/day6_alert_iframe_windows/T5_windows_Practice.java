package com.cydeo.tests.day6_alert_iframe_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5_windows_Practice {
    WebDriver driver ;
    @BeforeMethod
    public void  setupMethod() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        //3. Go to : https://practice.cydeo.com/windows
        driver.get("http://practice.cydeo.com/windows");
    }
    @Test
    public void multiple_window_test(){

//STORING the main pages

        String mainHandle= driver.getWindowHandle();
        System.out.println("mainHandle = " + mainHandle);
        //4. Assert: Title is “Windows”
        String expectedTitle="Windows";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        System.out.println("Title before click: "+actualTitle);

       //5. Click to: “Click Here” link
        WebElement clickHereLink=driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();


        //6. Switch to new Window.
      for(String each: driver.getWindowHandles()){
          driver.switchTo().window(each);
          System.out.println("Current title while switching windows: "+driver.getTitle());
      }

      //  //7. Assert: Title is “New Window”

        String expectedTitleAfterClick="New Window";
         actualTitle= driver.getTitle();
       Assert.assertEquals(actualTitle,expectedTitleAfterClick);
        System.out.println("Title after click: " +actualTitle);

        //if we want to go back to main page ,we can use already stored main handle
      //  driver.switchTo().window(mainHandle);
    }


   @AfterMethod
    public void tearDown(){
        driver.quit();
   }






    //7. Assert: Title is “New Window”



}
