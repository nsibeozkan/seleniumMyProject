package com.cydeo.tests.day4_findElements_checkboxes_radiobutton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class T1_xpath_cssSelector_practice {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);


       // 2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");

       //3. Locate all the WebElements on the page using XPATH and/or CSS
        //locator only (total of 6)
        //a. “Home” link
        //Locate home link for cssSelector
        WebElement homeLink_ex1= driver.findElement(By.cssSelector("a[class='nav-link']"));

        //using css syntax2 for home link
        WebElement homeLink_ex2= driver.findElement(By.cssSelector("a.nav-link"));

         //for home link using cssSelector with href
         WebElement homeLink_ex3= driver.findElement(By.cssSelector("a[href='/']"));

           //b. “Forgot password” header
          //locate header using sccSelector :locate parent element and move down to h2
          WebElement header_ex1= driver.findElement(By.cssSelector("div.example > h2"));

          //locate heeader using xpath:
          //WebElement header_ex2 =driver.findElement(By.xpath("//h2[.='Forgot Password']"))
           WebElement header_ex2 =driver.findElement(By.xpath("//h2[text()='Forgot Password']"));

         //c. “E-mail” text
         WebElement emailLabel= driver.findElement(By.xpath("//label[@for='email']"));
      //d. E-mail input box
        WebElement inputBox_ex1= driver.findElement(By.xpath("//input[@name='email']"));

        //using with xpath(with contain)
        //tagname[contains(@attribute,'value)]
        WebElement inputBox_ex2= driver.findElement(By.xpath("//input[contains(@pattern,'a-z')]"));

         //e.  “Retrieve password” button
        //     //button[@type='submit']
        //      //button[@class='radius'](we  can use this locator)
         WebElement retrievePasswordBth=driver.findElement(By.xpath("//button[@id='form_submit']"));

     //f. “Powered by Cydeo text

        WebElement poweredCydeoElement= driver.findElement(By.xpath("//div[@style='text-align: center;']"));

        //4. Verify all web elements are displayed.
        System.out.println("homeLink_ex1.isDisplayed() = " + homeLink_ex1.isDisplayed());
        System.out.println("homeLink_ex2.isDisplayed() = " + homeLink_ex2.isDisplayed());
        System.out.println("header_ex1.isDisplayed() = " + header_ex1.isDisplayed());
        System.out.println("header_ex2.isDisplayed() = " + header_ex2.isDisplayed());
        System.out.println("emailLabel.isDisplayed() = " + emailLabel.isDisplayed());
        System.out.println("poweredCydeoElement.isDisplayed() = " + poweredCydeoElement.isDisplayed());
        System.out.println("retrievePasswordBth.isDisplayed() = " + retrievePasswordBth.isDisplayed());
        driver.quit();


    }







}
/*










First solve the task with using cssSelector only. Try to create 2 different
cssSelector if possible

Then solve the task using XPATH only. Try to create 2 different
XPATH locator if possible

 */