package day1;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppHesapMakinesi {

    AndroidDriver<AndroidElement> driver; // Andorid driver sadece android cihazlar icin olusturulmus bir driver dir
    // Android cihazlar icin gerekli olan hazir methodlari bu driver ile birlikte kullanaarak cihaz ile ilgili islemleri yapabiliriz
    AppiumDriver<MobileElement> driver2; // Appium driver ise hem ios hem android isletim sistemine sahip olan cihazlar icin tasarlanmistir
    // bu driver ile birlikte iki farkli platformda da driver ile islmelerimizi gerceklestirbiliriz

    // EN TEMEL FARK !!!!! Android cihazlar kullanim farkliliklari daha zengin oldugu icin AndroidDriver sadece android cihazlara
    // ozel tasarlanmistir. Bu da bizlere android cihazlarda daha kullanisli bir driver kullanmamiza fayda saglar

    @Test
    public void hesapMakinesi() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2"); // eger kullanmis oldugumuz cihazin android
        // surumu 6 yada 6 dan buyukse UiAutomator2 kullanmamiz gerekiyor, 6 dan kucukse UiAutomator kullanmamiz gerekiyor
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\necme\\IdeaProjects\\Appium_T120\\Apps\\Calculator_8.4.1 (520193683)_Apkpure.apk");// uygulamayi cihaza yuklemek icin kullnailiyor

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // kullanici gerekli kurulumlari yapar
        // uygulamanin yuklnedigini dogrular(isInstalled)
        Assert.assertTrue(driver.isAppInstalled("com.google.android.calculator"));
        // uygulamanin acildigini dogrular
        Assert.assertTrue(driver.findElementByAccessibilityId("2").isDisplayed());
        // 100 un 5 katinin 500 oldugunu hesap makinesinden dogrulayalim

        driver.findElementByAccessibilityId("1").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("multiply").click();
        driver.findElementByAccessibilityId("5").click();

        String sonucKutusu = driver.findElementById("com.google.android.calculator:id/result_preview").getText();

        Assert.assertEquals(Integer.parseInt(sonucKutusu),500);





    }


}
