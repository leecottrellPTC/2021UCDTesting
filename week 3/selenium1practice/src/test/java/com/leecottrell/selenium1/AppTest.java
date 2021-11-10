package com.leecottrell.selenium1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.tagName;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;    //whichever driver you have
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    public static WebDriver driver;
    @BeforeClass
    public static void setupTest(){
        //System.setProperty("webdriver.gecko.driver", "c:\\selenium\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "c:\\selenium\\chromedriver.exe");
        //driver = new FirefoxDriver();
        
        //for headless
        ChromeOptions options = new ChromeOptions();
        //https://www.guru99.com/chrome-options-desiredcapabilities.html
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        
        //driver = new ChromeDriver();
        
    }

    @AfterClass
    public static void closeTest(){
        driver.quit();
    }
    @Test
    public void testBMIColor(){
        driver.get("https://www.cdc.gov/healthyweight/assessing/bmi/adult_bmi/english_bmi_calculator/bmi_calculator.html");
        WebElement feet = driver.findElement(By.id("feet"));
        WebElement inches= driver.findElement(By.id("inches"));
        WebElement pounds = driver.findElement(By.id("pounds"));
        WebElement calc = driver.findElement(By.id("calc"));
        
        WebElement link = driver.findElement(By.id("calc")); 

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link); 

        feet.sendKeys("5");
        inches.sendKeys("10");
        pounds.sendKeys("180");

        calc.click();
        WebElement bmiTable = driver.findElement(By.id("bmi_table"));
        //WebElement row3 = bmiTable.findElement(By.xpath("//tr[4]"));
        String expected = "rgba(197, 190, 225, 1)";
        //String actual = row3.getCssValue("background-color");
       // assertEquals("Background Color Purple",expected,actual );

       List <WebElement>rows = bmiTable.findElements(By.tagName("tr"));
       for(WebElement row:rows){
           List<WebElement>cols = row.findElements(By.tagName("td"));
           for(WebElement column:cols){
                if(column.getText().equals("Overweight")){
                    assertEquals("Background color wrong - overweight:",
                     expected, row.getCssValue("background-color"));
                }
                /*else{
                    assertEquals("Background color wrong - not overweight:",
                    "rgba(0, 0, 0, 0)", row.getCssValue("background-color"));
                }*/
           }
       }

    }
}



