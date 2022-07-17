package Tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {
    @Test
    public void testEx5() {
        SearchPageObject SerchPageObject = new SearchPageObject(driver);
        SerchPageObject.initSearchInput();
        SerchPageObject.typeSearchLine("Java");
        SerchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        String article_title = "object-oriented programming language";
        String name_of_folder = "Test";
        ArticlePageObject.addArticleToMyList1(name_of_folder);
        ArticlePageObject.closeArticle();
        SerchPageObject.initSearchInput();
        SerchPageObject.typeSearchLine("Wikipedia");
        SerchPageObject.clickByArticleWithSubstring("Free multilingual online encyclopedia");
        ArticlePageObject.addArticleToMyList_2(name_of_folder);
        ArticlePageObject.closeArticle();
        NavigationUI NavigationUI =new NavigationUI(driver);
        NavigationUI.ClickMyList();
        MyListsPageObject MyListsPageObject =new MyListsPageObject(driver);
        MyListsPageObject.openFolderByName(name_of_folder);
        MyListsPageObject.swipeByArticleToDelete(article_title);
        SerchPageObject.clickByArticleWithSubstring("free multilingual online encyclopedia");

    }
}
