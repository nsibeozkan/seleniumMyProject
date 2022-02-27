package com.cydeo.tests.day5_testNG_Intro_dropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class T1_StaleElementRefEx {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);

        //2. Go to https://practice.cydeo.com/add_remove_elements/
        driver.get("https://practice.cydeo.com/add_remove_elements/");

        //3. Click to “Add Element” button
        //button[@click='addElement()']
        WebElement addElementBtn= driver.findElement(By.xpath("//button[.='Add Element']"));
        Thread.sleep(1000);
        //3. Click to “Add Element” button
       addElementBtn.click();

       //4. Verify “Delete” button is displayed after clicking.


        WebElement deleteButton= driver.findElement(By.xpath("//button[@class='added-manually']"));
        System.out.println("deleteButton.isDisplayed() = " + deleteButton.isDisplayed());
        //5. Click to “Delete” button.
        deleteButton.click();
       //6. Verify “Delete” button is NOT displayed after clicking.

        try {
            System.out.println("deleteButton.isDisplayed() = " + deleteButton.isDisplayed());
        }catch (StaleElementReferenceException e){
            System.out.println("Stale element reference Exception is thrown");
            System.out.println("Web element is completely deleted ferom the page  ");
            System.out.println("deleteButton.isDisplayed() = "+false);
        }





        driver.quit();

    }






}
/*




USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
 */