package lib.ui;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {
    private static final String
            TITLE = "org.wikipedia:id/view_page_title_text",
            OPTIONS_BUTTON_1 = "//android.widget.ImageView[@content-desc='More options']",
            OPTIONS_ADD_TO_MY_LIST_BUTTON_1 = "//*[@text='Add to reading list']",
            ADD_TO_MY_LIST_OVERLAY_1 = "org.wikipedia:id/onboarding_button",
            MY_LIST_NAME_INPUT_1 = "org.wikipedia:id/text_input",
            MY_LIST_OK_BUTTON_1 = "//*[@text='OK']",
            CLOSE_ARTICLE_BUTTON ="//android.widget.ImageButton[@content-desc='Navigate up']",
            OPTIONS_BUTTON_2 ="//android.widget.ImageView[@content-desc='More options']",
            OPTIONS_ADD_TO_MY_LIST_BUTTON_2 = "//*[@text='Add to reading list']",
            MY_LIST_BUTTON ="//*[@text='Test']",
            AREA_CAPTURE ="//android.widget.ImageButton[@content-desc='Navigate up']";


    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    public WebElement waitForTitleElement() {
        return this.waitForElementPresent(By.id(TITLE), "Cannot find article title on page!", 15);
    }

    public String getArticleTitle() {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public void addArticleToMyList1(String name_of_folder) {
        this.waitForElementPresent(
                By.xpath(AREA_CAPTURE),
                "15",
                10
        );
        this.waitForElementAndClick(
                By.xpath(OPTIONS_BUTTON_1),
                "5.1",
                15
        );
        this.waitForElementPresent(
                By.xpath(OPTIONS_ADD_TO_MY_LIST_BUTTON_1),
                "5.2",
                10
        );
        this.waitForElementAndClick(
                By.xpath(OPTIONS_ADD_TO_MY_LIST_BUTTON_1),
                "6",
                20
        );
        this.waitForElementAndClick(
                By.id(ADD_TO_MY_LIST_OVERLAY_1),
                "7",
                20
        );
        this.waitForElementAndClear(
                By.id(MY_LIST_NAME_INPUT_1),
                "8",
                5
        );

        this.waitForElementAndSendKeys(
                By.id(MY_LIST_NAME_INPUT_1),
                "Test",
                "9",
                5
        );
        this.waitForElementAndClick(
                By.xpath(MY_LIST_OK_BUTTON_1),
                "10",
                5
        );
    }
    public void closeArticle()
    {
        this.waitForElementAndClick(
                By.xpath(CLOSE_ARTICLE_BUTTON),
                "11",
                5
        );
    }
    public void addArticleToMyList_2(String name_of_folder) {
        this.waitForElementPresent(
                By.xpath(AREA_CAPTURE),
                "15",
                10
        );
        this.waitForElementAndClick(
                By.xpath(OPTIONS_BUTTON_2),
                "5.1",
                15
        );
        this.waitForElementPresent(
                By.xpath(OPTIONS_ADD_TO_MY_LIST_BUTTON_2),
                "5.2",
                10
        );
        this.waitForElementAndClick(
                By.xpath(OPTIONS_ADD_TO_MY_LIST_BUTTON_2),
                "6",
                20
        );
        this.waitForElementAndClick(
                By.xpath(MY_LIST_BUTTON),
                "18",
                15
        );
    }
}
