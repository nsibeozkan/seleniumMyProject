package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_locator_getText {
    public static void main(String[] args) {
        //1- Open a chrome browser
        //2- Go to: https://login1.nextbasecrm.com/
         // WebDriverManager.chromedriver().setup();
         // WebDriver driver=new ChromeDriver();
          WebDriver driver= WebDriverFactory.getDriver("chrome");
          driver.manage().window().maximize();
          driver.get("https://login1.nextbasecrm.com/");

       // 3- Enter incorrect username: “incorrect”
       // driver.findElement(By.className("login-inp")).sendKeys("incorrect");
        WebElement inputUsername = driver.findElement(By.className("login-inp"));
        inputUsername.sendKeys("incorrect");

         //4- Enter incorrect password: “incorrect”
         //to auto generate local variable
         //mac:option+enter
          WebElement inputPassword= driver.findElement(By.name("USER_PASSWORD"));
         inputPassword.sendKeys("incorrect");


           //5- Click to login button.
          WebElement loginButton=  driver.findElement(By.className("login-btn"));
          loginButton.click();

            //6- Verify error message text is as expected:
            //Expected: Incorrect login or password
            WebElement errorMessage = driver.findElement(By.className("errortext"));
             String expectedErrorMessage="Incorrect login or password";
             String actualErrorMessage=errorMessage.getText();

             if(actualErrorMessage.equals(expectedErrorMessage)){
                 System.out.println("Error Message Verification PASSED");
             }else{
                 System.out.println("Error Message Verification FAILED");
             }


    }
}
