package ui.auto_login;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import okhttp3.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by dbudim on 19.12.2021
 */

public class TestrailAutologin {

    @BeforeMethod
    public void open() {
        Selenide.open("https://demoguild.testrail.io/");
        $("#button_primary").shouldBe(Condition.visible);
    }

    @AfterMethod
    public void quit(){
        WebDriverRunner.getWebDriver().quit();
    }

    @Test
    public void manualLogin() {
        $("#name").sendKeys("vegos21117@iistoria.com");
        $("#password").sendKeys("1qazXSW@");
        $("#button_primary").click();
        $("#button_primary").shouldNotBe(Condition.visible);
    }

    @Test
    public void autologin() throws IOException {
        List<Cookie> cookies = new ArrayList<>();
        CookieJar cookieJar = new CookieJar() {
            @Override
            public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
                cookies.addAll(list);
            }

            @Override
            public List<Cookie> loadForRequest(HttpUrl httpUrl) {
                return cookies;
            }
        };

        OkHttpClient client = new OkHttpClient().newBuilder()
                .cookieJar(cookieJar)
                .build();

        Request request = new Request.Builder()
                .url("https://demoguild.testrail.io/index.php?/auth/login/")
                .post(new FormBody.Builder()
                        .add("name", "vegos21117@iistoria.com")
                        .add("password", "1qazXSW@")
                        .build())
                .addHeader("authority", "demoguild.testrail.io")
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .build();

        client.newCall(request).execute();

        List<org.openqa.selenium.Cookie> collect = cookies.stream().map(c -> new org.openqa.selenium.Cookie(c.name(), c.value())).collect(Collectors.toList());
        collect.stream().forEach(WebDriverRunner.getWebDriver().manage()::addCookie);
    }
}
