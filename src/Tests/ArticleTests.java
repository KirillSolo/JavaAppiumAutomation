package Tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ArticleTests extends CoreTestCase {
    @Test
    public void testEx3() {
        SearchPageObject SerchPageObject = new SearchPageObject(driver);
        SerchPageObject.initSearchInput();
        SerchPageObject.typeSearchLine("Java");

        List<WebElement> counts_of_elements = driver.findElementsById("org.wikipedia:id/page_list_item_container");
        System.out.println(counts_of_elements.size());
        assert (counts_of_elements.size() > 1);

        SerchPageObject.waitForCancelButtonToAppear();
        SerchPageObject.clickCancelSearch();

        List<WebElement> counts_of_elements_2 = driver.findElementsById("org.wikipedia:id/page_list_item_container");
        System.out.println(counts_of_elements_2.size());
        assert (counts_of_elements_2.size() == 0);

    }
    @Test
    public void testEx6() {
        SearchPageObject SerchPageObject = new SearchPageObject(driver);
        SerchPageObject.initSearchInput();
        SerchPageObject.typeSearchLine("Wikipedia");
        SerchPageObject.clickByArticleWithSubstring ("Free multilingual online encyclopedia");
        List<WebElement> counts_of_elements = driver.findElementsById("org.wikipedia:id/view_page_title_text");
        ArticlePageObject ArticlePageObject =new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        System.out.println(counts_of_elements.size());
        assert (counts_of_elements.size() > 0);
    }
}
