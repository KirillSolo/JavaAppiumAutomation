package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MyListsPageObject extends MainPageObject
{
    public MyListsPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public  static final String
    FOLDER_BY_NAME_TPL = "//*[@resource-id='org.wikipedia:id/item_container']//*[@text='{FOLDER_NAME}']",
    ARTICLE_BY_TITLE_TPL = "//*[@resource-id='org.wikipedia:id/page_list_item_title']";
    private static String getFolderXpathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }
    private static String getSavedArticleXpathByTitle(String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }

    public void openFolderByName(String name_of_folder)
    {

        String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementPresent(
                By.xpath(folder_name_xpath),
                "21.1",
                5
        );

        this.waitForElementAndClick(
                By.xpath(folder_name_xpath),
                "22",
                5
        );
    }
    public void swipeByArticleToDelete(String article_title)
    {
        this.waitForElementPresent(
                By.xpath(ARTICLE_BY_TITLE_TPL),
                "21.1",
                5
        );
        this.swipefElementToLeft(
                By.xpath(ARTICLE_BY_TITLE_TPL),
                "23"
        );
    }
    public void waitForArticleToDisappearByTitle(String article_title)
    {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementNotPresent(By.xpath(article_xpath),"Saved article still present with title" + article_title,20);
    }
    public void waitForArticleToAppearByTitle(String article_title)
    {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementPresent(By.xpath(article_xpath),"Cannot find saved article by title" + article_title,15);
    }
}
