package com.big.o.listeners;

import org.testng.IInvokedMethodListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dbudim on 11.12.2021
 */

public class TimeTrackListener implements ITestListener, IInvokedMethodListener {

    private static Map<String, Long> tests = Collections.synchronizedMap(new HashMap<>());

    public void onTestSuccess(ITestResult result) {
        var name = result.getMethod().getMethodName();
        var duration = result.getEndMillis() - result.getStartMillis();
        tests.put(name, duration);
        System.out.println(name + ": " + duration);
        System.out.println("......................");
        System.out.println(" ");
    }

}
