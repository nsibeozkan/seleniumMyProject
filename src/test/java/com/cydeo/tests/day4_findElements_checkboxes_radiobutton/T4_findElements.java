package com.cydeo.tests.day4_findElements_checkboxes_radiobutton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T4_findElements {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);

         //2- Go to: https://practice.cydeo.com/abtest
       driver.get("https://practice.cydeo.com/abtest");

        //    3- Locate all the links in the page.
        //mac:option+enter;(onemli)
       List<WebElement> allLinks= driver.findElements(By.tagName("a"));
       //print out the number of the links on the page
        System.out.println("allLinks.size() = " + allLinks.size());

        //   5- Print out the texts of the links.
        //mac:command+shift+up or down arrow
        for (WebElement each : allLinks) {
            System.out.println("Text of link: " + each.getText());
            System.out.println("HREF Values:  " + each.getAttribute("href"));
        }






driver.quit();

      /*



        5- Print out the texts of the links.
        6- Print out the HREF attribute values of the links*/
    }
}
