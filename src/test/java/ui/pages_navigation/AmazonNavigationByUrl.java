package ui.pages_navigation;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by dbudim on 19.12.2021
 */

public class AmazonNavigationByUrl {

    @BeforeClass
    public void openMainPage() {
        Selenide.open("https://www.amazon.com/");
    }

    @Test
    public void openListsByUrl() {
        Selenide.open("https://www.amazon.com/hz/wishlist/intro");
        $("#my-lists-tab").shouldBe(Condition.visible);
    }

}
