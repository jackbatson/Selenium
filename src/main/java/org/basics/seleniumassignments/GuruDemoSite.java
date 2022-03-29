package org.basics.seleniumassignments;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;



public class GuruDemoSite {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/register.php");

        WebElement firstName = driver.findElement(By.xpath("//*[@name='firstName']"));
        firstName.sendKeys("Jack");

        WebElement lastName = driver.findElement(By.xpath("//*[@name='lastName']"));
        lastName.sendKeys("Batson");

        WebElement phoneNumber = driver.findElement(By.xpath("//input[@name='phone']"));
        phoneNumber.sendKeys("123");

      // Auto generation of email ID

        WebElement email = driver.findElement(By.xpath("//input[@id='userName']"));

        email.sendKeys(RandomStringUtils.randomAlphabetic(8) + ("@jackbatson.com"));


        WebElement address = driver.findElement(By.xpath("//input[@name='address1']"));
        address.sendKeys("Danger Forest, Billston Island");

        WebElement cityName = driver.findElement(By.xpath("//input[@name='city']"));
        cityName.sendKeys("Arthurton");

        WebElement state = driver.findElement(By.xpath("//input[@name='state']"));
        state.sendKeys("True Heaven");

        WebElement postalCode = driver.findElement(By.xpath("//input[@name='postalCode']"));
        postalCode.sendKeys("3333");

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

    }
}

