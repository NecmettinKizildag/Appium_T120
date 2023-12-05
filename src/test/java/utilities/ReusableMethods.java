package utilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

public class ReusableMethods {



    public static void tiklamaMethodu(int xKoordinati, int yKoordinati,int beklemeSuresi) throws InterruptedException {
        TouchAction action = new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(xKoordinati,yKoordinati))
                .release()
                .perform();
        Thread.sleep(beklemeSuresi);
    }

    public static void screenScrollMethod(int xBaslangicKoordinati, int yBaslangicKoordinati,int kaydirmaSuresi, int xBitisKoordinati, int yBitisKoordinati, int beklemeSuresi) throws InterruptedException {
        TouchAction action = new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(xBaslangicKoordinati,yBaslangicKoordinati))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(kaydirmaSuresi)))
                .moveTo(PointOption.point(xBitisKoordinati,yBitisKoordinati))
                .release()
                .perform();
        Thread.sleep(beklemeSuresi);
    }

}
