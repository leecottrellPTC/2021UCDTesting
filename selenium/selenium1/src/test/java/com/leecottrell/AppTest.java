package com.leecottrell;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    
    public static WebDriver driver;

    @BeforeClass
    public static void setupTest(){
        System.setProperty("webdriver.chrome.driver", "c:\\selenium\\chromedriver98.exe");

        //headless mode - Chrome stays in RAM
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);

        //driver = new ChromeDriver();//see chrome, headed mode

        //driver.get("http://www.leecottrell.com");
    }

    @Test
    public void testLoginPage(){
        /*
            ARRANGE    
            load the page in the driver
            link the elements on the screen to variables in code

            ACT
            interact with the elements via code
            load a new set of elements on the screen

            ASSERT
            assert that something is true
        */

        driver.get("http://demo.guru99.com/test/login.html");
        WebElement email = driver.findElement(By.id("email"));
        WebElement passwd = driver.findElement(By.id("passwd"));
        WebElement button = driver.findElement(By.id("SubmitLogin"));
        email.sendKeys("you@somewhere.com");
        passwd.sendKeys("12345");
        button.click();

        //may need to pause  - later lecture

        WebElement h3 = driver.findElement(By.xpath("/html/body/div[4]/div/div/h3"));
        String actual = h3.getText();   //stripping the text from the screen, screen scraping
        String expected = "Successfully Logged in...";
        assertEquals(expected, actual);
    

    }

    @AfterClass
    public static void closeTest(){
        driver.close(); //close chrome after the test - very important
    }


}
