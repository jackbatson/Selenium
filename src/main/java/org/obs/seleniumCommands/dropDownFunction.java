package org.obs.seleniumCommands;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.sun.deploy.net.socket.UnixDomainSocketException;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.text.html.HTMLDocument;

public class dropDownFunction {
    WebDriver driver;

    public WebDriver testInitialise(String chrome) {

        String browserName = "chrome";
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            try {
                throw new Exception("invalid browser Name");

            } catch (Exception e) {

            }
        }

        //driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }

    @BeforeMethod

    public void setUp() {
        testInitialise("chrome");


    }

    @AfterMethod
    public void tearDown() {
//driver.close();
    }


    @Test
    public void verifyHomePage() {
        driver.get("https://demo.guru99.com/test/newtours/index.php");

    }

    @Test
    public void verifyRegisterAndSubmitButton() {
        driver.get("https://demo.guru99.com/test/newtours/index.php");
        driver.findElement(By.xpath("//a[normalize-space()='REGISTER']")).click();
        String text1 = driver.findElement(By.xpath("//td[@class='mouseOut']//a[contains(text(),'REGISTER')]")).getText();
        System.out.println(text1);
        String text2 = driver.findElement(By.name("submit")).getAttribute("type");
        System.out.println(text2);


    }

    @Test
    public void verifyTheDropDown() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstName']"));
        firstName.sendKeys("Jack");
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastName']"));
        lastName.sendKeys("Batson");
        WebElement phoneNumber = driver.findElement(By.xpath("//input[@name='phone']"));
        phoneNumber.sendKeys("123");
        WebElement emailId = driver.findElement(By.xpath("//input[@id='userName']"));
        emailId.sendKeys(RandomStringUtils.randomAlphabetic(8) + ("@jackbatson.com"));
        WebElement address = driver.findElement(By.xpath("//input[@name='address1']"));
        address.sendKeys("Danger Forest, Billston Island");
        WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
        city.sendKeys("Arthurton");
        WebElement state = driver.findElement(By.xpath("//input[@name='state']"));
        state.sendKeys("Dantus Valley");
        WebElement postCode = driver.findElement(By.xpath("//input[@name='postalCode']"));
        postCode.sendKeys("0001");
        //using dropdown to select country
        WebElement country = driver.findElement(By.xpath("//select[@name='country']"));
        Select select = new Select(country);
        select.selectByVisibleText("SWITZERLAND");
        //select.selectByIndex(20);
        //select.selectByValue("SWEDEN");
        WebElement userName = driver.findElement(By.xpath("//input[@id='email']"));
        userName.sendKeys("jackbatson");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("1234567");
        WebElement confirmPassword = driver.findElement(By.xpath("//input[@name='confirmPassword']"));
        confirmPassword.sendKeys("1234567");
        WebElement submitButton = driver.findElement(By.xpath("//input[@name='submit']"));
        submitButton.click();


    }

    @Test
    public void alertButton() {
        driver.get("https://demoqa.com/alerts");
        WebElement alert = driver.findElement(By.id("alertButton"));
        alert.click();
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();/*
    }
    @Test
    public void alertButton2(){
        driver.get("https://demoqa.com/alerts");
        WebElement alert = driver.findElement(By.id("timerAlertButton"));
        alert.click();
        Alert alert2= driver.switchTo().alert();
        alert2.accept();*/
    }

    @Test
    public void hdfcbank() {
        driver.get("https://www.hdfcbank.com/");
        WebElement productType = driver.findElement(By.xpath("//div[@class='drp1']//a"));
        productType.click();
        WebElement accounts = driver.findElement(By.xpath("//li[text()='Accounts']"));
        accounts.click();
        WebElement product = driver.findElement(By.xpath(" //div[@class='drp2']//a"));
        product.click();
        WebElement savings = driver.findElement(By.xpath(" //li[text()='Savings Accounts']"));
        savings.click();

    }

    @Test
    public void alertButton3() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.id("confirmButton")).click();
        Alert alert2 = driver.switchTo().alert();
        String textTwoAlert = alert2.getText();
        System.out.println(textTwoAlert);
        Thread.sleep(3000);
        alert2.accept();
        //alert2.dismiss();
        Thread.sleep(3000);
        driver.switchTo().defaultContent();


    }

    @Test
    public void alertButton4() throws InterruptedException, UnixDomainSocketException {
        driver.get("https://demo.guru99.com/test/delete_customer.php");
        WebElement deleteCustomer = driver.findElement(By.xpath("//input[@name='cusid']"));
        deleteCustomer.sendKeys("Jack123");
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();
        Alert alert3 = driver.switchTo().alert();
        String textThreeAlert = alert3.getText();
        System.out.println(textThreeAlert);
        Thread.sleep(3000);
        alert3.accept();
        alert3.dismiss();

    }

    @Test
    public void verifyWindowPage() {
        driver.get("https://demo.guru99.com/popup.php");
        String parentWindow = driver.getWindowHandle();
        System.out.println(parentWindow);
        WebElement clickHere = driver.findElement(By.xpath("//a[@target='_blank']"));
        clickHere.click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> windowIterator1 = windows.iterator();
        while (windowIterator1.hasNext()) {
            String child_window = windowIterator1.next();
            if (!parentWindow.equals(child_window)) {
                driver.switchTo().window(child_window);
                WebElement emailField = driver.findElement(By.xpath("//input[@type='text']"));
                emailField.sendKeys("jackbatson@gmail.com");
                WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
                submitButton.click();
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow);
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
    //Window Handles function
    @Test
    public void verifyWindowAAlert() throws InterruptedException {
        driver.get("https://omayo.blogspot.com/");
       String firstWindow= driver.getWindowHandle();
       Thread.sleep(3000);

        driver.findElement(By.linkText("Open a popup window")).click();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> itr = windows.iterator();
        while(itr.hasNext()){
            String window = itr.next();
            driver.switchTo().window(window);
            if(driver.getTitle().equals("Basic Web Page Title")){
                driver.close();
            }
        }
driver.switchTo().window(firstWindow);
        driver.findElement(By.name("q")).sendKeys("Jack Batson");
    }

    @Test
    public void verifyDropDown() {
        driver.navigate().to("https://demo.guru99.com/test/newtours/");
        driver.findElement(By.xpath("//a[normalize-space()='REGISTER']")).click();
        List<WebElement> registerMenu = driver.findElements(By.xpath("//td[@class='mouseOut']//a[contains(text(),'REGISTER')]"));
        for (WebElement option : registerMenu) {
            String value = option.getText();
            if (value.equalsIgnoreCase("REGISTER")) {
                option.click();
                break;

            }
        }
    }
}






