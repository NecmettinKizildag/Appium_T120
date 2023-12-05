package tests.day3;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.KiwiPages;
import utilities.Driver;
import utilities.ReusableMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.*;

public class KiwiApp {

    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();

    KiwiPages kiwiPages = new KiwiPages();

    @Test
    public void kiwiAppTest() throws InterruptedException {
        // uygulamanin yuklendigi dogrulanir
        assertTrue(driver.isAppInstalled("com.skypicker.main"));

        // uygulamanin basariyla acildigi dogrulanir
        assertTrue(kiwiPages.misafirButonu.isDisplayed());

        // misafir olarak devam et e tiklanir
        kiwiPages.misafirButonu.click();

        // ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
        TouchAction action = new TouchAction<>(driver);

        for (int i = 0; i <3 ; i++) {
            ReusableMethods.tiklamaMethodu(540,1690,1000);
        }

        // Trip type,one way olarak secilir
        Thread.sleep(2000);

        ReusableMethods.tiklamaMethodu(400,620,250);

        kiwiPages.oneWayButonu.click();
        Thread.sleep(1000);

        // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir


        // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
        // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        // gidis tarihi eylul ayinin 21 i olarak secilir ve set date e tiklanir
        // search butonuna tiklanir
        // en  ucuz ve aktarmasiz filtrelemeleri yapilir
        // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir


    }
}
