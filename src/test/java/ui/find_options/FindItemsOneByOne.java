package ui.find_options;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.containExactTextsCaseSensitive;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by dbudim on 18.12.2021
 */

public class FindItemsOneByOne {

    @BeforeClass
    public void prepareData() {
        open("https://www.imdb.com/chart/top/?ref_=nv_mv_250");
    }

    @Test
    public void containsSingle() {
        $$(".titleColumn [title]").shouldHave(containExactTextsCaseSensitive("The Shawshank Redemption"));
        $$(".titleColumn [title]").shouldHave(containExactTextsCaseSensitive("The Godfather"));
        $$(".titleColumn [title]").shouldHave(containExactTextsCaseSensitive("The Dark Knight"));
        $$(".titleColumn [title]").shouldHave(containExactTextsCaseSensitive("Whiplash"));
    }
}
