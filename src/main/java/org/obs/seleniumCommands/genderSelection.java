package org.obs.seleniumCommands;

import com.sun.deploy.security.SelectableSecurityManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.text.normalizer.Utility;

import java.util.List;

public class genderSelection {


    WebDriver driver;

    public void testInitialise(String browser) {

        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();

        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();

        } else if (browser.equals("edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\Selenium\\drivers\\msedgeDriver.exe");
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

    public void selectGender(String gender) {
        List<WebElement> genderSelection = driver.findElements(By.xpath("//label[contains(@for,'gender')]"));
        //Compare the actual values with the expected values in gender options list
        for (int i = 0; i < genderSelection.size(); i++) {
            if (genderSelection.get(i).getText().equalsIgnoreCase(gender)) {
                // equalsIgnoreCase compares two strings, ignoring lower case and upper case differences
                //It returns true if the strings are equal, and false if not
                genderSelection.get(i).click();
            }
        }

    }

    @BeforeMethod
    public void setUp() {
        testInitialise("chrome");
    }

    @AfterMethod
    public void tearDown() {
        //   driver.close();
    }

    @Test
    public void verifyRegistration() {
        driver.get("http://demowebshop.tricentis.com/");
        WebElement login = driver.findElement(By.cssSelector("li>a[class='ico-register']"));
        login.click();
        selectGender("Male");
        WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.sendKeys("Jack");
        WebElement lastName = driver.findElement(By.xpath("//input[@id='LastName']"));
        lastName.sendKeys("Batson");


        WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));

        email.sendKeys(RandomStringUtils.randomAlphabetic(8) + ("@jackbatson.com"));
        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("123456");
        WebElement reenterPassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        reenterPassword.sendKeys("123456");
        WebElement register = driver.findElement(By.xpath("//input[@id='register-button']"));
        register.click();
        WebElement result = driver.findElement(By.xpath("//div[@class='result']"));
        String actualText = result.getText();
        String expectedText = "Your registration completed";
        Assert.assertEquals(actualText, expectedText, "Not Registered");
    }

    @Test
    public void verifyPromptAlert() {
        driver.get("https://demoqa.com/alerts");
        WebElement promptButton = driver.findElement(By.id("promtButton"));
        promptButton.click();
        Alert alert = driver.switchTo().alert();
        String alertString = alert.getText();
        System.out.println(alertString);
        alert.sendKeys("HI");
        alert.accept();
        //alert.dismiss();
    }

    @Test
    public void verifyDropDown() {
        driver.navigate().to("https://demo.guru99.com/test/newtours/");
        driver.findElement(By.xpath("//a[normalize-space()='REGISTER']")).click();
       List<WebElement>registerMenu = driver.findElements(By.xpath("//td[@class='mouseOut']//a[contains(text(),'REGISTER')]"));
       for (WebElement option: registerMenu){
           String value= option.getText();
           if(value.equalsIgnoreCase("REGISTER")){
           option.click();
           break;
           }
       }


       WebElement dropdown= driver.findElement(By.xpath("//select[@name='country']"));
       Select select = new Select(dropdown);
       select.selectByVisibleText("INDIA");




        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();




        WebElement country = driver.findElement(By.xpath("//option[text()='SWITZERLAND']"));
        country.click();


        WebElement userName = driver.findElement(By.xpath("//input[@id='email']"));
        userName.sendKeys("jackbatson");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("1234567");

        WebElement reenterPassword = driver.findElement(By.xpath("//input[@name='confirmPassword']"));
        reenterPassword.sendKeys("1234567");

        WebElement submit = driver.findElement(By.xpath("//input[@name='submit']"));
        submit.click();
        //WebElement country = driver.findElement(By.xpath("//select[@name='country']"));
        //country.click("option[value='COLOMBIA']");

        dropdown = driver.findElement(By.xpath("//select[@name='country']"));
        select = new Select(dropdown);
        select.deselectByVisibleText("INDIA");
        select.selectByValue("INDIA");
        select.selectByIndex(20);




       /* List<WebElement> dropDownValues = select.getOptions();
        System.out.println(dropdownValues.size());
        for(
                int i = 0; i<dropdownValues.size();i++)
                */


    }


    {
       // System.out.println(dropDownValues.get(i).getText());

    }
}



