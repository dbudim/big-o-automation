package ui.auto_login;

import com.big.o.ui.pages.PinterestLoginPage;
import com.big.o.ui.pages.PinterestSettingsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by dbudim on 19.12.2021
 */

public class PinterestAutologin {

    private PinterestLoginPage loginPage = new PinterestLoginPage();
    private PinterestSettingsPage settingsPage = new PinterestSettingsPage();

    @BeforeMethod
    public void login() throws IOException {
        long start = System.currentTimeMillis();
        loginPage.autoLogin("pagexer608@ritumusic.com", "1qazXSW@");
        long end = System.currentTimeMillis();
        System.out.println("Login auto time: " + (end - start));
    }

    @Test
    public void openSettings() {
        settingsPage
                .open()
                .assertIsOpened();
    }
}
