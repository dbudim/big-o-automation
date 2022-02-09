package com.big.o.ui.pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by dbudim on 19.12.2021
 */

public class PinterestSettingsPage {

    public PinterestSettingsPage open() {
        Selenide.open("https://www.pinterest.ru/settings");
        assertIsOpened();
        return this;
    }

    public void assertIsOpened() {
        $("[data-test-id='settings-header']").shouldBe(visible);
    }


}
