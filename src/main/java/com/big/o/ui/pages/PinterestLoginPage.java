package com.big.o.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by dbudim on 19.12.2021
 */

public class PinterestLoginPage {

    public SelenideElement loginBtn = $("[data-test-id='simple-login-button']");
    public SelenideElement emailField = $("#email");
    public SelenideElement passField = $("#password");
    public SelenideElement submitBtn = $("[data-test-id='registerFormSubmitButton']");

    public void open() {
        Selenide.open("https://www.pinterest.ru");
    }

    public void asserIsOpened() {
        loginBtn.shouldNotBe(Condition.visible);
    }


    public void login(String email, String pass) {
        open();
        loginBtn.click();
        emailField.sendKeys(email);
        passField.sendKeys(pass);
        submitBtn.click();
        $("[data-test-id='pin']").shouldBe(Condition.visible);
    }

    public void autoLogin(String email, String pass) throws IOException {
        open();
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
                .url("https://accounts.pinterest.com/v3/login/handshake/")
                .post(new FormBody.Builder()
                        .add("username_or_email", email)
                        .add("password", pass)
                        .add("token", "default@")
                        .build())
                .addHeader("authority", "accounts.pinterest.com")
                .addHeader("content-type", "application/x-www-form-urlencoded; charset=UTF-8")
                .addHeader("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36")
                .addHeader("origin", "https://www.pinterest.ru")
                .addHeader("sec-fetch-site", "cross-site")
                .addHeader("sec-fetch-mode", "cors")
                .addHeader("sec-fetch-dest", "empty")
                .addHeader("referer", "https://www.pinterest.ru/")
                .addHeader("accept-language", "ru-RU,ru;q=0.9")
                .build();
        client.newCall(request).execute();
        cookies.stream()
                .map(c -> new org.openqa.selenium.Cookie(c.name(), c.value()))
                .forEach(WebDriverRunner.getWebDriver().manage()::addCookie);
    }
}
