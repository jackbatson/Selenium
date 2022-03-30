package org.obs.seleniumCommands;

import com.sun.deploy.net.socket.UnixDomainSocketException;
import javafx.scene.input.InputMethodTextRun;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.imageio.metadata.IIOMetadataNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.apache.logging.log4j.core.async.AsyncLoggerContextSelector.isSelected;
import static org.openqa.selenium.By.linkText;
public class SeleniumCommands {
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

    @BeforeMethod
    public void setUp() {
        testInitialise("chrome");
    }

    @AfterMethod
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void verifyHomePageTitle() {
        driver.get("http://demowebshop.tricentis.com/");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Demo Web Shop";
        Assert.assertEquals(actualTitle, expectedTitle, "Invalid Page Title");
    }

    @Test
    public void verifyLogin() {
        driver.get("http://demowebshop.tricentis.com");
        //go to login page:
        WebElement login = driver.findElement(By.cssSelector("a.ico-login"));
        login.click();
        //enter email:
        WebElement email = driver.findElement(By.cssSelector("input#Email"));
        email.sendKeys("jackbatson@jackbatson.com");
        //enter password:
        WebElement password = driver.findElement(By.cssSelector("input[type='password']"));
        password.sendKeys("123456");
        WebElement checkin = driver.findElement(By.cssSelector("input[id='RememberMe']"));
        checkin.click();
        WebElement loginbutton = driver.findElement(By.cssSelector("input[value='Log in']"));
        loginbutton.click();
        WebElement account = driver.findElement(By.xpath("//div[@class='header-links']//a[@class='account']"));
        String actualemailID = account.getText();
        String expectedemailID = "jackbatson@jackbatson.com";
        Assert.assertEquals(actualemailID, expectedemailID, "User login Failed");
    }

    @Test
    public void verifyClear() {
        driver.get("http://demowebshop.tricentis.com");
        WebElement login = driver.findElement(By.cssSelector("a.ico-login"));
        login.click();
        WebElement email = driver.findElement(By.cssSelector("input#Email"));
        email.sendKeys("jackbatson@jackbatson.com");
        WebElement password = driver.findElement(By.cssSelector("input[type='password']"));
        password.sendKeys("123456");
        email.clear();
        WebElement checkin = driver.findElement(By.cssSelector("input[id='RememberMe']"));
        checkin.click();
        WebElement loginbutton = driver.findElement(By.cssSelector("input[value='Log in']"));
        loginbutton.click();
    }

    @Test
    public void verifyWebElementCommand() {
        driver.get("http://demowebshop.tricentis.com");
        WebElement login = driver.findElement(By.cssSelector("a.ico-login"));
        login.click();
        WebElement loginbutton = driver.findElement(By.cssSelector("input[value='Log in']"));
        Dimension dimension = loginbutton.getSize();
        int height = dimension.height;
        int width = dimension.width;
        System.out.println("height= " + height);
        System.out.println("width= " + width);
        Point point = loginbutton.getLocation();
        int x = point.x;
        int y = point.y;
        System.out.println("X cordinate = " + x);
        System.out.println("Y cordinate = " + y);
        String ActualLoginButtonText = loginbutton.getAttribute("value");
        System.out.println(ActualLoginButtonText);
        String ExpectedLoginButtonText = "Log in";
        //Assert.assertEquals(ActualLoginButtonText, ExpectedLoginButtonText, "Incorrect text in login button" );
        // String tagname= login.getTagName();
        //System.out.println("tagName "+tagname);
        String cssValue = loginbutton.getCssValue("color");
        System.out.println(cssValue);
    }

    @Test
    public void verifySearchButton() {
        driver.get("http://demowebshop.tricentis.com");
        WebElement login = driver.findElement(By.cssSelector("a.ico-login"));
        login.click();
        WebElement searchButton = driver.findElement(By.cssSelector("input[value='Search']"));
        Dimension dimension = searchButton.getSize();
        int height = dimension.height;
        int width = dimension.width;
        System.out.println("height= " + height);
        System.out.println("width= " + width);
        Point point = searchButton.getLocation();
        int x = point.x;
        int y = point.y;
        System.out.println("X cordinate = " + x);
        System.out.println("Y cordinate = " + y);
        String ActualSearchButtonText = searchButton.getAttribute("value");
        System.out.println(ActualSearchButtonText);
        String ExpectedSearchButtonText = "Search";
        //Assert.assertEquals(ActualSearchButtonText, ExpectedSearchButtonText, "Incorrect text in search button" );

    }

    @Test
    public void findGender() {
        driver.get("http://demowebshop.tricentis.com/register");
        //WebElement findGender= (WebElement) driver.findElements(By.className("forcheckbox"));
        //WebElement findGender = (WebElement) driver.findElements(By.name("Gender"));

        //WebElement genderSelection = driver.findElement(By.id("gender-male"));
        //Creating a List
        List<String> list = new ArrayList<String>();
        //Adding elements in the List
        list.add("gender-male");
        list.add("gender-female");
        //Iterating the List element using for-each loop
        for (String gender : list)
            System.out.println(gender);
        System.out.println(driver.findElement(By.id("gender-male")));
    }

    @Test
    public void verifyElementPresent() {
        driver.get("http://demowebshop.tricentis.com");
        WebElement login = driver.findElement(By.cssSelector("a.ico-login"));
        login.click();
        WebElement loginbutton = driver.findElement(By.cssSelector("input[value='Log in']"));
        Boolean result = loginbutton.isDisplayed();
        System.out.println(result);
        Assert.assertTrue(result, "Submit button not displayed");
    }

    @Test
    public void verifyElementEnabled() {
        driver.get("http://demowebshop.tricentis.com");
        WebElement login = driver.findElement(By.cssSelector("a.ico-login"));
        login.click();
        WebElement loginbutton = driver.findElement(By.cssSelector("input[value='Log in']"));
        Boolean enabledStatus = loginbutton.isEnabled();
        System.out.println(enabledStatus);
        Assert.assertTrue(enabledStatus, "Submit button not enabled");
    }

    @Test
    public void verifyCheckBoxSelectionStatus() {
        driver.get("http://demowebshop.tricentis.com");
        WebElement login = driver.findElement(By.cssSelector("a.ico-login"));
        login.click();
        WebElement checkin = driver.findElement(By.cssSelector("input[id='RememberMe']"));
        Boolean selectionStatusBeforeTick = checkin.isSelected();
        System.out.println(selectionStatusBeforeTick);
        Assert.assertFalse(selectionStatusBeforeTick, "Checkbox selection is not expected");
        checkin.click();
        Boolean selectionStatus = checkin.isSelected();
        System.out.println(selectionStatus);
        Assert.assertTrue(selectionStatus, "checkin button not selected ");
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
        alert1.accept();
    /*}
    @Test
    public void alertButton2(){
        driver.get("https://demoqa.com/alerts");
        WebElement alert = driver.findElement(By.id("timerAlertButton"));
        alert.click();
        Alert alert2= driver.switchTo().alert();
        alert2().accept();*/
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

    @Test
    public void verifyFramesInSelenium() {
        driver.get("https://demoqa.com/frames");
        //driver.switchTo().frame(1);
        //driver.switchTo().frame("frame1");
        WebElement frameElement = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frameElement);
        WebElement heading = driver.findElement(By.id("sampleHeading"));
        String sampleHeading = heading.getText();
        System.out.println(sampleHeading);

    }



    @Test
    public void verifyFirstSelectedColour() {
        driver.get("https://selenium.obsqurazone.com/select-input.php");
        WebElement multiSelectionBoxField = driver.findElement(By.id("multi-select-field"));
        Select select = new Select(multiSelectionBoxField);
        select.selectByVisibleText("Red");
        select.selectByVisibleText("Yellow");
        select.selectByVisibleText("Green");
        WebElement firstClicked = driver.findElement(By.id("button-first"));
        firstClicked.click();
        WebElement element = select.getFirstSelectedOption();
        System.out.println(firstClicked.getText());
        System.out.println(driver.findElement(By.id("message-two")).getText());
    }

    @Test
    public void verifySelectedColour() {
        driver.get("https://selenium.obsqurazone.com/select-input.php");
        WebElement dropDownBox = driver.findElement(By.id("single-input-field"));
        Select select = new Select(dropDownBox);
        select.selectByVisibleText("Red");
        String selectedColour = driver.findElement(By.id("message-one")).getText();
        System.out.println("The " + selectedColour);
    }

    @Test
    public void verifyMulltiSelectedColour() {
        driver.get("https://selenium.obsqurazone.com/select-input.php");
        WebElement multiSelectionField = driver.findElement(By.id("multi-select-field"));
        Select select = new Select(multiSelectionField);
        List<WebElement> multiSelectionOptions = select.getOptions();
        for (int i = 1; i < multiSelectionOptions.size(); i++) {
            System.out.println(multiSelectionOptions.get(i).getText());
    }

    }

    @Test
    public void verifyDeselectedColour() throws InterruptedException {
        driver.get("https://selenium.obsqurazone.com/select-input.php");
        WebElement deselectMultiSelectionField = driver.findElement(By.id("multi-select-field"));
        Select select = new Select(deselectMultiSelectionField);
        select.selectByVisibleText("Red");
        select.selectByVisibleText("Yellow");
        select.selectByVisibleText("Green");
        Thread.sleep(3000);
        select.deselectByVisibleText("Green");

    }

    @Test
    public void verifySelectedColourOptions() {
        driver.get("https://selenium.obsqurazone.com/select-input.php");
        WebElement selectedColourField = driver.findElement(By.id("single-input-field"));
        driver.findElement(By.xpath("//*[@id='single-input-field']//option[ @value='Red']")).click();
        Select select = new Select(selectedColourField);
        driver.findElement(By.id("message-one")).getText();
        System.out.println();
        System.out.println(driver.findElement(By.id("message-one")).getText());
    }
    @Test
    public void verifyRightClick(){
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement rightClick = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        Actions action = new Actions(driver);
        action.contextClick(rightClick).build().perform();

    }
    @Test
    public void verifyDoubleClick(){
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement doubleClick=driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
        Actions action = new Actions(driver);
        action.doubleClick(doubleClick).build().perform();
        Alert alert = driver.switchTo().alert();
        String alertString = alert.getText();
        System.out.println(alertString);
        alert.accept();
    }
    @Test
    public void verifyMouseHover1(){
        driver.get("https://demoqa.com/menu/");
        WebElement mainElementOne = driver.findElement(By.xpath("//a[normalize-space()='Main Item 1']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(mainElementOne).perform();
    }@Test
    public void verifyMouseHover2(){
        driver.get("https://demoqa.com/menu/");
        WebElement mainElementTwo = driver.findElement(By.xpath("//a[normalize-space()='Main Item 2']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(mainElementTwo).perform();
        WebElement option2 = driver.findElement(By.xpath("//a[normalize-space()='SUB SUB LIST »']"));
        actions.moveToElement(option2).perform();
        WebElement option3 = driver.findElement(By.xpath("//a[normalize-space()='Sub Sub Item 2']"));
        actions.moveToElement(option3).click().build().perform();


    }




}










