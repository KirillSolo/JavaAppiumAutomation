package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainPageObject {
    private static final String
    MY_LISTS_LINK ="//android.widget.FrameLayout[@content-desc='My lists']",
    AREA_CAPTURE= "//android.widget.FrameLayout[@content-desc='My lists']";
    public NavigationUI(AppiumDriver driver)
    {
        super(driver);
    }
    public void ClickMyList()
    {
        this.waitForElementPresent(
                By.xpath(AREA_CAPTURE),
                "20",
                10
        );
        this.waitForElementAndClick(
                By.xpath(MY_LISTS_LINK),
                "21",
                10
        );
    }
}
