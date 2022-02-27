package com.cydeo.tests.day4_findElements_checkboxes_radiobutton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class T5_checkboxes {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        //Go to http://practice.cydeo.com/checkboxes
        driver.get("http://practice.cydeo.com/checkboxes");

       // 2. Confirm checkbox #1 is NOT selected by default
       WebElement checkbox1= driver.findElement(By.xpath("//input[@name='checkbox1']"));
        System.out.println("checkbox1.isSelected() = " + checkbox1.isSelected());

        //  3. Confirm checkbox #2 is SELECTED by default.
        WebElement checkbox2= driver.findElement(By.xpath("//input[@name='checkbox2']"));
        System.out.println("checkbox2.isSelected() = " + checkbox2.isSelected());
          Thread.sleep(3000);
        // 4. Click checkbox #1 to select it.
            checkbox1.click();
         Thread.sleep(3000);
        //5. Click checkbox #2 to deselect it.
        checkbox2.click();
        System.out.println("---------------------------");
        // 6. Confirm checkbox #1 is SELECTED.
        System.out.println("checkbox1.isSelected() = " + checkbox1.isSelected());
        // 7. Confirm checkbox #2 is NOT selected.
        System.out.println("checkbox2.isSelected() = " + checkbox2.isSelected());

        if(checkbox1.isSelected()){
            System.out.println("Verification is PASSED");
        }else{
            System.out.println("Verification is FAILED");
        }

        if(!checkbox2.isSelected()){
            System.out.println("Verification passed");
        }else{
            System.out.println("Verification failed");
        }










        driver.quit();



        /*





         */
    }
}
