package ui.pages_navigation;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by dbudim on 19.12.2021
 */

public class AmazonNavigationManual {

    @BeforeClass
    public void openMainPage() {
        Selenide.open("https://www.amazon.com/");
    }

    @Test
    public void openLists() {
        $("#nav-hamburger-menu").click();
        $$(".hmenu-item").find(Condition.text("Your Account")).click();
        $("[data-card-identifier='YourLists']").click();
        $("#my-lists-tab").shouldBe(Condition.visible);
    }

}
