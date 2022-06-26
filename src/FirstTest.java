import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;
import java.util.Set;

public class FirstTest {

    private AppiumDriver driver;

    @Before
    public void setUp () throws Exception
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("plarformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion","8.0");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("app","C:\\Users\\k.solovyev\\Desktop\\JavaAppiumAutomation\\apks\\org.wikipedia.apk");
        driver = new AndroidDriver (new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }
    @After
    public void tearDown()
    {
        driver.quit ();
    }

    private void assertElementHasText (String locator, String searchingText, String error_message, long timeoutInSecond)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSecond);
        //wait.withMessage(error_message + "\n");

        By element = By.id(locator);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        String foundedText = driver.findElement(By.id(locator)).getText();
        Assert.assertEquals(error_message, searchingText, foundedText);
    }

    @Test
    public void TestEx2()
    {
        WebElement element_to_init_search =driver.findElementByXPath("//*[contains(@text,'Search Wikipedia')]");
        element_to_init_search.click();

                assertElementHasText(
                "org.wikipedia:id/search_src_text",
                "Search…",
                "Can't find text 'Search…' in string",
                5
        );
    }
    @Test
    public void TestEx3 ()
    {
        WebElement element_to_init_search =driver.findElementByXPath("//*[contains(@text,'Search Wikipedia')]");
        element_to_init_search.click();
        WebElement element_to_enter_search_line = driver.findElementByXPath("//*[contains(@text,'Search…')]");
        element_to_enter_search_line.sendKeys ("Java");
        List <WebElement> counts_of_elements = driver.findElementsById("org.wikipedia:id/page_list_item_container");
        System.out.println(counts_of_elements.size());
        assert (counts_of_elements.size()>1);
        WebElement clear_list = driver.findElementById("org.wikipedia:id/search_close_btn");
        clear_list.click();
        List <WebElement> counts_of_elements_2 = driver.findElementsById("org.wikipedia:id/page_list_item_container");
        System.out.println(counts_of_elements_2.size());
        assert (counts_of_elements_2.size()==0);
    }
}
