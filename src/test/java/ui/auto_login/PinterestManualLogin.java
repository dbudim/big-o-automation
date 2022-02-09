package ui.auto_login;

import com.big.o.ui.pages.PinterestLoginPage;
import com.big.o.ui.pages.PinterestSettingsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class PinterestManualLogin {

    private PinterestLoginPage loginPage = new PinterestLoginPage();
    private PinterestSettingsPage settingsPage = new PinterestSettingsPage();

    @BeforeMethod
    public void login() {
        long start = System.currentTimeMillis();
        loginPage.login("wagomaj458@pyrelle.com", "1qazXSW@");
        long end = System.currentTimeMillis();
        System.out.println("Login manual time: " + (end - start));
    }

    @Test
    public void openSettings() {
        settingsPage
                .open()
                .assertIsOpened();
    }
}
