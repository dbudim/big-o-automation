package com.big.o.listeners;

import com.codeborne.selenide.Configuration;
import org.testng.ISuite;
import org.testng.ISuiteListener;

/**
 * Created by dbudim on 19.12.2021
 */

public class SelenideConfigurationListener implements ISuiteListener {

    public void onStart(ISuite suite) {
        Configuration.timeout = 10000;
    }
}
