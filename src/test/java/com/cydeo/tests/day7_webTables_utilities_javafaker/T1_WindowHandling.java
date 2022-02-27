package com.cydeo.tests.day7_webTables_utilities_javafaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_WindowHandling {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
  driver= WebDriverFactory.getDriver("chrome");
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);

    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }




   @Test
   public void window_handling_test(){
      //2. Go to : https://www.amazon.com/
      driver.get("https://www.amazon.com/");

      //3. Copy paste the lines from below into your class hazirdi copy paste yaptik.
       ((JavascriptExecutor) driver).executeScript("window.open('https://google.com','_blank');");
       ((JavascriptExecutor) driver).executeScript("window.open('https://etsy.com','_blank');");
       ((JavascriptExecutor) driver).executeScript("window.open('https://facebook.com','_blank');");

       //4. Create a logic to switch to the tab where Etsy.com is open
         BrowserUtils.switchWindowAndVerify(driver,"etsy","Etsy");







   }







}
/*


4. Create a logic to switch to the tab where Etsy.com is open
5. Assert: Title contains “Etsy”



These lines will simply open new tabs using something called JavascriptExecutor
and get those pages. We will learn JavascriptExecutor later as well.
 */