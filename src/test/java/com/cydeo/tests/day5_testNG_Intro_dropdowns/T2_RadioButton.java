package com.cydeo.tests.day5_testNG_Intro_dropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class T2_RadioButton {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);


        //2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");

       //3. Click to “Hockey” radio button
        WebElement hockeyRadioBtn= driver.findElement(By.xpath("//input[@id='hockey']"));
        Thread.sleep(2000);
        //3. Click to “Hockey” radio button
        hockeyRadioBtn.click();

       //4. Verify “Hockey” radio button is selected after clicking.
      if(hockeyRadioBtn.isSelected()){
         System.out.println(" Button is selected. Verification PASSED.");
       }else{
          System.out.println(" Button is not  selected. Verification FAILED!!!");
      }





    }
}
