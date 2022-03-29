package org.basics.seleniumassignments;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class Amazon {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");

        //login to amazon.in

        driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']")).click();

        // enter credentials into the login button

        driver.findElement(By.id("ap_email")).sendKeys("contact@adappur.com");

        // click on continue button to login
        driver.findElement(By.xpath("//*[contains(@class, 'a-button-input')]")).click();

        //Enter password

        driver.findElement(By.cssSelector("#ap_password")).sendKeys("Adappur@123");

        // Click on check box remember me

        driver.findElement(By.xpath("//*[@name='rememberMe']")).click();

        Thread.sleep(3000);
        //click on sign in button to login

        driver.findElement(By.xpath("//*[@id='signInSubmit']")).click();
        Thread.sleep(3000);

        //search keyword "Georgekutty adappur" in amazon.in search button

        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("georgekutty adappur");

        driver.findElement(By.cssSelector("#nav-search-submit-button")).click();

        //Select book Jack Batson and the Holy Grail to add to cart

        driver.findElement(By.xpath("//span[normalize-space()='Jack Batson and the Holy Grail']")).click();

        driver.findElement(By.id("add-to-ebooks-cart-button")).click();

        //driver.navigate().toString(By.ById);

        //click on number of products button to choose how many copies needed


        //choose 10 copies of the book

       //Select quantity= new Select(


        //Select quantity= new Select(driver.findElement(By.id("add-to-ebooks-cart-button")));



       // driver.findElement(By.id("quantity-dropdown-select_0")).findElement
              //  (By.xpath("//span[@id='quantity-dropdown']//span[@class='a-button-text a-declarative']")).findElement
                //(By.xpath("(By.xpath(\"//a[@id='quantity-dropdown-select_9']"));


        driver.findElement(By.id("quantity-dropdown-select_9")).click();

        //close the web browser

       // driver.close();


        /*
// register amazon.in

        driver.findElement(By.id("createAccountSubmit")).click();

        driver.findElement(By.id("ap_customer_name")).sendKeys("adappur");

        driver.findElement(By.id("ap_email")).sendKeys("contact@adappur.com");

        driver.findElement(By.id("ap_password")).sendKeys("Adappur@123");

        driver.findElement(By.id("ap_password_check")).sendKeys("Adappur@123");

        driver.findElement(By.xpath("//input[@id='continue']")).click();

        driver.findElement(By.className("home_children_button")).click();*/





    }
}
