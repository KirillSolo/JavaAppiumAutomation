import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;

public class FirstTest {

    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("plarformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "C:\\Users\\k.solovyev\\Desktop\\JavaAppiumAutomation\\apks\\org.wikipedia.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    private void assertElementHasText(String locator, String searchingText, String error_message, long timeoutInSecond) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSecond);
        //wait.withMessage(error_message + "\n");

        By element = By.id(locator);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        String foundedText = driver.findElement(By.id(locator)).getText();
        Assert.assertEquals(error_message, searchingText, foundedText);
    }

    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

//    private WebElement waitForElementPresent(By by, String error_message)
//    {
//        return waitForElementPresent(by, error_message, 5);
//    }

    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    private WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }
    protected void swipeUp (int timeOfSwipe)
    {
        TouchAction action = new TouchAction(driver);
        Dimension size =driver.manage().window().getSize();
        int x = size.width / 2;
        int start_y =(int)(size.height * 0.8);
        int end_y =(int)  (size.height * 0.2);
        action
                .press(x,start_y)
                .waitAction(timeOfSwipe)
                .moveTo(x,end_y)
                .release()
                .perform();
    }

    protected void swipefElementToLeft(By by, String error_message)
    {
        WebElement element = waitForElementPresent(
                by,
                error_message,
                10
        );
        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;

        TouchAction action = new TouchAction(driver);
        action
                .press(right_x,middle_y)
                .waitAction(600)
                .moveTo(left_x,middle_y)
                .release()
                .perform();
    }

    @Test
    public void TestEx2() {
        WebElement element_to_init_search = driver.findElementByXPath("//*[contains(@text,'Search Wikipedia')]");
        element_to_init_search.click();

        assertElementHasText(
                "org.wikipedia:id/search_src_text",
                "Search…",
                "Can't find text 'Search…' in string",
                5
        );
    }

    @Test
    public void TestEx3() {
        WebElement element_to_init_search = driver.findElementByXPath("//*[contains(@text,'Search Wikipedia')]");
        element_to_init_search.click();
        WebElement element_to_enter_search_line = driver.findElementByXPath("//*[contains(@text,'Search…')]");
        element_to_enter_search_line.sendKeys("Java");
        List<WebElement> counts_of_elements = driver.findElementsById("org.wikipedia:id/page_list_item_container");
        System.out.println(counts_of_elements.size());
        assert (counts_of_elements.size() > 1);
        WebElement clear_list = driver.findElementById("org.wikipedia:id/search_close_btn");
        clear_list.click();
        List<WebElement> counts_of_elements_2 = driver.findElementsById("org.wikipedia:id/page_list_item_container");
        System.out.println(counts_of_elements_2.size());
        assert (counts_of_elements_2.size() == 0);
    }

    @Test
    public void TestEx5() {
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "1",
                5
        );
        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search…')]"),
                "Java",
                "2",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "3",
                15
        );

        waitForElementPresent(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "4",
                10
        );

        waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
                "5.1",
                15
        );
        waitForElementPresent(
                By.xpath("//*[@text='Add to reading list']"),
                "5.2",
                10
                );
        waitForElementAndClick(
                By.xpath("//*[@text='Add to reading list']"),
                "6",
                20
        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/onboarding_button"),
                "7",
                20
        );
        waitForElementAndClear(
                By.id("org.wikipedia:id/text_input"),
                "8",
                5
        );
        String name_of_folder = "Test";
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/text_input"),
                name_of_folder,
                "9",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[@text='OK']"),
                "10",
                5
        );
        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "11",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "12",
                5
        );
        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search…')]"),
                "Wikipedia",
                "13",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Free multilingual online encyclopedia']"),
                "14",
                10
        );
        waitForElementPresent(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "15",
                10
        );

        waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
                "16",
                20
        );

        waitForElementAndClick(
                By.xpath("//*[@text='Add to reading list']"),
                "17",
                25
        );
        waitForElementAndClick(
                By.xpath("//*[@text='Test']"),
                "18",
                15
        );
        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "19",
                10
        );
        waitForElementPresent(
                By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
                "20",
                10
        );
        waitForElementAndClick(
                By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
                "21",
                10
        );
        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/item_container']//*[@text='"+name_of_folder+"']"),
                "22",
                5
        );
        swipefElementToLeft(
                By.xpath("//*[@text='Java (programming language)']"),
                "23"
        );
        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='free multilingual online encyclopedia']"),
                "24",
                5
        );

        waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "25",
                0
        );
    }
}

