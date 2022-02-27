package com.cydeo.tests.day6_alert_iframe_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_Alert_Practices {
   WebDriver driver ;
  @BeforeMethod
  public void  setupMethod() {
      driver= WebDriverFactory.getDriver("chrome");
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
      //2. Go to website: http://practice.cydeo.com/javascript_alerts
      driver.get("http://practice.cydeo.com/javascript_alerts");
  }
   @Test
   public void alert_test1() {
       WebElement informationAlertButton= driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
           //3. Click to “Click for JS Alert” button
       informationAlertButton.click();

      //to be  able to click to ALERT OK BUTTON we need to switch driver's focus to Alert itself.
       Alert alert=driver.switchTo().alert();
       //4. Click to OK button from the alert
       alert.accept();
       // Verify “You successfully clicked an alert” text is displayed.
       WebElement resultText=driver.findElement(By.xpath("//p[@id='result']"));
       //FAILURE message will be only displayed if assertion fails:"Result text is NOT DISPLAYED"
       Assert.assertTrue(resultText.isDisplayed(),"Result text is NOT DISPLAYED");

       String expectedText="You successfully clicked an alert";
       String actualText=resultText.getText();
       Assert.assertEquals(actualText,expectedText,"Actual result test is not as expected !!1");


   }






}
/*




5. Verify “You successfully clicked an alert” text is displayed.
 */