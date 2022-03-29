package org.obs.seleniumCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumCommandsOriginal {
    WebDriver driver;

    public void testInitialise(String browser) {

        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();

        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();

        } else if (browser.equals("edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\Selenium\\drivers\\edgeDriver.exe");
            ;
            driver = new EdgeDriver();
        } else {
            try {
                throw new Exception("invalid browserName");
            } catch (Exception e) {
            }
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void setUp(){
        testInitialise("chrome");

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
    @Test
    public void verifyHomePageTitle(){
        driver.get("http://demowebshop.tricentis.com/");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Demo Web Shop";
        Assert.assertEquals(actualTitle, expectedTitle, "Invalid Page Title");
    }
    @Test
    public void verifyLogin(){
        driver.get("http://demowebshop.tricentis.com");

        //go to login page:

        WebElement login = driver.findElement(By.cssSelector("a.ico-login"));
        login.click();


        //enter email:

       WebElement email= driver.findElement(By.cssSelector("input#Email"));
       email.sendKeys("jackbatson@jackbatson.com");

       //enter password:

        WebElement password= driver.findElement(By.cssSelector("input[type='password']"));
        password.sendKeys("123456");

        //check remember me button

        WebElement checkin = driver.findElement(By.cssSelector("input[id='RememberMe']"));
        checkin.click();


        // click login button

        WebElement loginbutton = driver.findElement(By.cssSelector("input[value='Log in']"));
        loginbutton.click();

        // Verify logged in to the account

      /*  WebElement actualUserName = driver.findElement(By.xpath("//a[contains(text(),'jackbatson@jackbatson.com')]"));
        actualUserName.isSelected();*/


       WebElement account= driver.findElement(By.xpath("//div[@class='header-links']//a[@class='account']"));
        String actualemailID=account.getText();
        String expectedemailID="jackbatson@jackbatson.com";
        Assert.assertEquals(actualemailID,expectedemailID,"User login Failed");
    }
}


