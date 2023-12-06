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
        ReusableMethods.tiklamaMethodu(405,774,500);
        ReusableMethods.tiklamaMethodu(1011,136,750);

        // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
        if (!driver.isKeyboardShown()){
            kiwiPages.aramaKutusu.sendKeys("istanbul");
        }  else {
            driver.getKeyboard().pressKey("istanbul");
        }

        Thread.sleep(1000);

        ReusableMethods.tiklamaMethodu(369,292,1000);

        kiwiPages.chooseButton.click();

        // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        kiwiPages.anywhereButton.click();

        driver.getKeyboard().pressKey("varsova");

        Thread.sleep(1000);

        ReusableMethods.tiklamaMethodu(369,292,1000);

        kiwiPages.chooseButton.click();

        Thread.sleep(1000);

        // gidis tarihi ocak ayinin 21 i olarak secilir ve set date e tiklanir
        kiwiPages.anytimeButton.click();

        Thread.sleep(1000);

        ReusableMethods.screenScrollMethod(541,1341,800,548,482,250);

        ReusableMethods.tiklamaMethodu(117,1352,1000);

        // search butonuna tiklanir
        kiwiPages.searchButton.click();

        Thread.sleep(4000);

        // en  ucuz ve aktarmasiz filtrelemeleri yapilir
        ReusableMethods.tiklamaMethodu(259,259,500);

        ReusableMethods.tiklamaMethodu(409,584,500);

        kiwiPages.stopsButton.click();

        kiwiPages.nonstopButton.click();

        // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir


    }
}
