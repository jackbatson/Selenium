package org.basics.seleniumassignments;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class Amazon {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");

        //login to amazon.in

        driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']")).click();
// register amazon.in

        driver.findElement(By.id("createAccountSubmit")).click();

        driver.findElement(By.id("ap_customer_name")).sendKeys("adappur");

        driver.findElement(By.id("ap_email")).sendKeys("contact@adappur.com");

        driver.findElement(By.id("ap_password")).sendKeys("Adappur@123");

        driver.findElement(By.id("ap_password_check")).sendKeys("Adappur@123");

        driver.findElement(By.xpath("//input[@id='continue']")).click();

        driver.findElement(By.className("home_children_button")).click();





    }
}
