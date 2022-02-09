package ui.find_options;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.stream.Collectors;

import static com.codeborne.selenide.CollectionCondition.containExactTextsCaseSensitive;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static java.util.List.of;

/**
 * Created by dbudim on 18.12.2021
 */

public class FindItemsBulk {

    @BeforeClass
    public void prepareData() {
        open("https://www.imdb.com/chart/top/?ref_=nv_mv_250");
    }

    @Test
    public void containsBulk() {
        var expectedFilms = of("The Shawshank Redemption", "The Godfather", "The Dark Knight", "Whiplash");
        $$(".titleColumn [title]").shouldHave(containExactTextsCaseSensitive(expectedFilms));
    }

    @Test
    public void containsBulkN() {
        var films = $$(".titleColumn [title]").texts().stream().collect(Collectors.toSet());

        SoftAssert sa = new SoftAssert();
        sa.assertTrue(films.contains("The Shawshank Redemption"),"The Shawshank Redemption not found");
        sa.assertTrue(films.contains("The Godfather"),"The Godfather not found");
        sa.assertTrue(films.contains("The Dark Knight"),"The Dark Knight not found");
        sa.assertTrue(films.contains("Whiplash"),"Whiplash not found");
        sa.assertAll();
    }
}
