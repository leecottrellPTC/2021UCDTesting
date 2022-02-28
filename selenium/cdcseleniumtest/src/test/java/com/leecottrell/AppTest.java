package com.leecottrell;

import static org.junit.Assert.*;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppTest {

    public static WebDriver driver;

    @BeforeClass
    public static void setupTest() {
        System.setProperty("webdriver.chrome.driver", "c:\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void clostTest() {
        driver.close();
    }

    @Test
    public void testCDC_BMI_Tables() throws Exception{
        driver.get("https://www.cdc.gov/healthyweight/assessing/bmi/adult_bmi/english_bmi_calculator/bmi_calculator.html");
        WebElement feet = driver.findElement(By.id("feet"));
        WebElement inches = driver.findElement(By.id("inches"));
        WebElement pounds = driver.findElement(By.xpath("/html/body/div[6]/main/div[3]/div/div[4]/div[2]/div/div/div[1]/div[1]/div/div[2]/div[2]/div[2]/ul/li/div/div[2]/div/input"));
        WebElement calcButton = driver.findElement(By.id("calc"));

        feet.sendKeys("5");
        inches.sendKeys("10");
        pounds.sendKeys("160");
        calcButton.click();

        // test
        //Thread.sleep(5000); //simple pause

        //Explicit
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
       // wait.until(ExpectedConditions.presenceOfElementLocated(By.id("bmi_table")));
        //https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/ExpectedConditions.html

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement bmiTable = driver.findElement(By.id("bmi_table"));
        

       // WebElement row3 = bmiTable.findElement(By.xpath("//tr[3]"));
       // System.out.println(row3.getCssValue("background-color"));
       String expected = "rgba(197, 190, 225, 1)";
       String actual = "";

       List<WebElement> rows = bmiTable.findElements(By.tagName("tr"));
 
       for(WebElement row : rows){
           List<WebElement> cols = row.findElements(By.tagName("td"));
           for(WebElement col : cols){
               if(col.getDomProperty("textContent").contains("Healthy")){
                   actual = row.getCssValue("background-color");
               }
           }
       }//end for

       File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       FileUtils.copyFile(scrFile, new File("c:\\selenium\\screenshots\\healthyBMIScreenShot.png"));

       assertEquals(expected, actual);
    }

















    @Ignore
    public void testCDC_BMICalc() {
        driver.get(
                "https://www.cdc.gov/healthyweight/assessing/bmi/adult_bmi/english_bmi_calculator/bmi_calculator.html");
        /*
         * link to the page
         * get the webelements
         * automate the elements - put text, click ...
         * 
         * get new webelements
         * test the result
         */

        // setup web elements
        WebElement feet = driver.findElement(By.id("feet"));
        WebElement inches = driver.findElement(By.id("inches"));
        WebElement pounds = driver.findElement(By.xpath(
                "/html/body/div[6]/main/div[3]/div/div[4]/div[2]/div/div/div[1]/div[1]/div/div[2]/div[2]/div[2]/ul/li/div/div[2]/div/input"));
        WebElement calcButton = driver.findElement(By.id("calc"));

        feet.sendKeys("5");
        inches.sendKeys("10");
        pounds.sendKeys("160");
        calcButton.click();

        WebElement bmiNum = driver.findElement(By.className("bmiNum"));
        String expected = "23";
        String actual = bmiNum.getDomProperty("textContent");

        assertEquals(expected, actual);

    }

}
