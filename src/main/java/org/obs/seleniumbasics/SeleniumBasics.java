package org.obs.seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("http://demowebshop.tricentis.com/login");



        //Web Element
       // WebElement email = driver.findElement(By.id("Email"));
       // WebElement email = driver.findElement(By.name("Email"));

        //WebElement email = driver.findElement(By.className("email"));
       //WebElement email = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
        WebElement email =  driver.findElement(By.cssSelector("#Email"));
        email.sendKeys("contact@adappur.com" );


        //close browser

        //driver.close();
    }


}
