package tests.day2;

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

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class appArabam {

    AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");

        capabilities.setCapability("appPackage","com.dogan.arabam");
        // apPackage bir uygulamanin kimlik bilgisidir . biz bu capability sayesinde hangi uygulama uzerinde calisacagimizi test oncesinde belirtebiliriz
        capabilities.setCapability("appActivity","com.dogan.arabam.presentation.feature.home.HomeActivity");
        // appActivity uzerinde caisacak oldugumuz uygulamanin hangi sayfa penceresinden baslayacagimizi belirtir.
        // yani biz bu capability sayesinde uygulama icerisindeki farkli pencerelerden uygulamayi baslatabiliriz.
        // bunun icin gerekli activity degerlerine sahip olmamiz gerekir.

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void arabamTest() throws InterruptedException {
        // driver.activateApp("com.dogan.arabam");

        // uygulamanin basarili bir sekilde yuklendigi dogrulanir
        assertTrue(driver.isAppInstalled("com.dogan.arabam"));

        // uygulaminin basarili bir sekilde acildigi dogrulanir
        assertTrue(driver.findElementByXPath("//*[@text='Alırken, satarken kullanırken']").isDisplayed());

        // alt menuden ilan ara butonuna tiklanir
        driver.findElementByXPath("//*[@text='İlan Ara']").click();

        // kategori olarak otomobil secilir
        driver.findElementByXPath("//*[@text='Otomobil']").click();

        // arac olarak Volkswagen secilir
        Thread.sleep(2000);

        TouchAction action = new TouchAction<>(driver);
        action.press(PointOption.point(540,1622)) // press kismi ekranda tiklama kaydirma islemi icin tiklama yapacagimiz ilk nokta
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(70))) // baslangic noktasi ile bitis noktasi arasinda gecen sure
                .moveTo(PointOption.point(540,0)) // baslangic noktasindan baslayarak gidelecek bitis noktasinin koordinatlarini ifade eder
                .release() // parmagimizi tipki gunluk kullanimdaki gibi ekrandan kaldirma serbest birakma eylemidir
                .perform(); // verilen action gorevlerini yerine getirmesi icin actiona verilen komuttur

        //driver.findElementByXPath("//*[@text='Volkswagen']").click();
        action.press(PointOption.point(230,1286))
                .release()
                .perform();

        // arac markasi olarak passat secilir
        driver.findElementByXPath("//*[@text='Passat']").click();


        // 1.4 TSI BlueMotion secilir
        driver.findElementByXPath("//*[@text='1.4 TSi BlueMotion']").click();


        // Paket secimi yapilir
        driver.findElementByXPath("//*[@text='Highline']").click();


        // Ucuzdan pahaliya siralama yaparak filtreleme yapilir
        driver.findElementById("com.dogan.arabam:id/textViewSorting").click();
        driver.findElementByXPath("//*[@text='Fiyat - Ucuzdan Pahalıya']").click();
        Thread.sleep(2000);

        // Gelen en ucuz aracin 500.000 tl den buyuk oldugu dogrulanir
        String aracFiyati = driver.findElementByXPath("//*[@resource-id='com.dogan.arabam:id/tvPrice']").getText();
        System.out.println(aracFiyati);

        aracFiyati = aracFiyati.replaceAll("\\D","");

        System.out.println(aracFiyati);

        int aracFiyatiInt = Integer.parseInt(aracFiyati);

        assertTrue(aracFiyatiInt>500000);
    }
}
