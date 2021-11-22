package com.leecottrell.selenium1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.tagName;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver; //whichever driver you have
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.imageio.IIOException;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */

    public static WebDriver driver;
    public static String movieURL = "https://www.rottentomatoes.com/m/eternals/reviews";

    List<String> reviewsText = new ArrayList<String>();

    int marvelCount = 0;

    @BeforeClass
    public static void setupTest() {
        // System.setProperty("webdriver.gecko.driver",
        // "c:\\selenium\\geckodriver.exe");
        // System.setProperty("webdriver.chrome.driver",
        // "c:\\!selenium\\chromedriver\\chromedriver.exe");
        // driver = new FirefoxDriver();

        // for headless
        // ChromeOptions options = new ChromeOptions();
        // https://www.guru99.com/chrome-options-desiredcapabilities.html
        // options.addArguments("--headless");
        // driver = new ChromeDriver(options);

        // driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver\\chromedriver.exe");
        // driver = new ChromeDriver();

        ChromeOptions options = new ChromeOptions();
        // https://www.guru99.com/chrome-options-desiredcapabilities.html
        options.addArguments("--headless");
        // driver = new ChromeDriver(options);
        driver = new ChromeDriver();
    }

    public void stripSite() {
        
        try {
            
            Thread.sleep(5000);

           // Boolean wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedCondition.visibilityOfElementLocated(By.className("the_review") ))
            List<WebElement> allReviews = driver.findElements(By.className("the_review"));
            for (WebElement aReview : allReviews) {
                reviewsText.add(aReview.getText());
                if (aReview.getText().contains("podcast")) {
                    marvelCount++;
                }
            }
        } catch (Exception ex) {
           assertTrue("Stripsite is stale", false);
        }

    }

    @Test
    public void testMovieSite() {
        // count the number of times Marvel appears in a review
        driver.get(movieURL);
        // List<WebElement> allReviews =
        // driver.findElements(By.className("the_review"));
        // List<String> reviewsText = new ArrayList<String>();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int x = 0; x < 3; x++) {
            stripSite();
            try {
                WebElement nextBn = driver
                        .findElement(By.xpath("/html/body/div[5]/div[3]/div[2]/section/div/div/div/nav[2]/button[2]"));
                js.executeScript("arguments[0].scrollIntoView()", nextBn);
                nextBn.click();
            } catch (Exception ex) {
                assertTrue("Test is stale", false);
            }
        }
        int c = 1;

        System.out.println("Reviews scraped " + reviewsText.size());
        System.out.println("Marvel mentioned " + marvelCount + " times");
        int anotherMarvelCount = 0;
        for(String s : reviewsText){
            System.out.println(c + " " + s);
            c++;
            if(s.contains("Jolie")){
                anotherMarvelCount++;
            }
        }
        System.out.println("worst Second Count " + anotherMarvelCount);

    }

    @Ignore
    public void testPause() {
        driver.get("http://www.leecottrell.com");

        /*
         * try { Thread.sleep(5000); } catch (InterruptedException e) { // TODO
         * Auto-generated catch block e.printStackTrace(); }
         */

        // implicit test
        /*
         * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         * //implicitlyWait(10, TimeUnit.SECONDS)
         * 
         * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); try{
         * WebElement footer = driver.findElement(By.xpath("/html/body/footer"));
         * }finally{ assertTrue("Timeout failed", false); }
         */

        // explicit wait
        Boolean div = new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.titleContains("Lee"));

        assertEquals("Title is bad", "Lee Cottrell", driver.getTitle());
    }

    @Ignore
    public void testScreenshot() {
        driver.get("http://www.leecottrell.com");
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("c:\\data\\screenshots\\home.png"));
        } catch (IOException ie) {
            assertTrue("home.png is not created", false);
        }
    }

    @Ignore
    public void testIt() {
        driver.get("http://www.leecottrell.com");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // fullscreen
        // driver.manage().window().maximize();
        // driver.navigate().
        // String results = (String) js.executeAsyncScript("alert('wow!')");
        // hold onto the return
        // js.executeAsyncScript("window.scrollBy(0, 500)");
        // 0 is x, 500 is Y
        // scroll until something is visible
        WebElement footer = driver.findElement(By.xpath("/html/body/footer"));

        js.executeScript("arguments[0].scrollIntoView()", footer);
    }

    @AfterClass
    public static void closeTest() {
        driver.quit();
    }

    @Ignore
    public void testBMIColor() {
        driver.get(
                "https://www.cdc.gov/healthyweight/assessing/bmi/adult_bmi/english_bmi_calculator/bmi_calculator.html");
        WebElement feet = driver.findElement(By.id("feet"));
        WebElement inches = driver.findElement(By.id("inches"));
        WebElement pounds = driver.findElement(By.id("pounds"));
        WebElement calc = driver.findElement(By.id("calc"));

        WebElement link = driver.findElement(By.id("calc"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link);

        feet.sendKeys("5");
        inches.sendKeys("10");
        pounds.sendKeys("180");

        calc.click();
        WebElement bmiTable = driver.findElement(By.id("bmi_table"));
        // WebElement row3 = bmiTable.findElement(By.xpath("//tr[4]"));
        String expected = "rgba(197, 190, 225, 1)";
        // String actual = row3.getCssValue("background-color");
        // assertEquals("Background Color Purple",expected,actual );

        List<WebElement> rows = bmiTable.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for (WebElement column : cols) {
                if (column.getText().equals("Overweight")) {
                    assertEquals("Background color wrong - overweight:", expected, row.getCssValue("background-color"));
                }
                /*
                 * else{ assertEquals("Background color wrong - not overweight:",
                 * "rgba(0, 0, 0, 0)", row.getCssValue("background-color")); }
                 */
            }
        }

    }
}
