package org.basics.seleniumassignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class seleniumDay1 {
    public static void main(String[] args) throws InterruptedException {

                System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\drivers\\chromedriver.exe");
                WebDriver driver = new ChromeDriver();
                driver.manage().deleteAllCookies();
                driver.manage().window().maximize();
                driver.get("http://demowebshop.tricentis.com/login");


                //Web Element

                //To login to the app

                WebElement email = driver.findElement(By.className("email"));
                email.sendKeys("jackbatson@jackbatson.com");
                Thread.sleep(2000);
                WebElement password = driver.findElement(By.className("password"));
                password.sendKeys("123456");
                driver.findElement(By.id("RememberMe")).click();
                driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")).click();

                Thread.sleep(2000);
                //To go to register account page
                driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.center-2 > div > div.page-body > div.customer-blocks > div.new-wrapper.register-block > div.buttons > input")).click();

                //Enter details in the registration form
                driver.findElement(By.id("gender-male")).click();//click on radio button to choose male
                 Thread.sleep(2000);
                 driver.findElement(By.name("FirstName")).sendKeys("Jack");
                 driver.findElement(By.id("LastName")).sendKeys("Batson");
                 Thread.sleep(2000);
                 driver.findElement(By.name("Email")).sendKeys("jackbatson@jackbatson.com");
                 driver.findElement(By.name("Password")).sendKeys("123456");
                 driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("123456");
                 Thread.sleep(2000);
                 driver.findElement(By.xpath("//*[@id=\"register-button\"]")).click();
                 Thread.sleep(2000);

                // WebElement email = driver.findElement(By.id("Email"));
                // WebElement email = driver.findElement(By.name("Email"));


                //WebElement email = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
                //WebElement email =  driver.findElement(By.cssSelector("#Email"));
                // email.sendKeys("contact@adappur.com" );

        //Webelement by using linktext and partial link text
        //WebElement email = driver.findElement(By.linkText("login"));
        //WebElement email = driver.findElement(By.partialLinkText("log"));
        List<WebElement> tag = driver.findElement(By.tagName("a"));

                Thread.sleep(3000);
                //close browser

                driver.close();
            }


        }

