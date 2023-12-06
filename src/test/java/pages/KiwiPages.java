package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class KiwiPages {

    public KiwiPages(){
        PageFactory.initElements((WebDriver)Driver.getAndroidDriver(),this);
    }

    @FindBy(xpath = "//*[@text='Continue as a guest']")
    public WebElement misafirButonu;

    @FindBy(xpath = "//*[@class='android.view.View'][4]")
    public WebElement aramaKutusu;

    @FindBy(xpath = "//*[@text='One way']")
    public WebElement oneWayButonu;

    @FindBy(xpath = "//*[@text='Choose']")
    public WebElement chooseButton;

    @FindBy(xpath = "(//*[@text='Anywhere'])[2]")
    public WebElement anywhereButton;

    @FindBy(xpath = "(//*[@text='Anytime'])[2]")
    public WebElement anytimeButton;

    @FindBy(xpath = "(//*[@text='Search'])[1]")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@text='Stops']")
    public WebElement stopsButton;

    @FindBy(xpath = "//*[@text='Nonstop']")
    public WebElement nonstopButton;

    @FindBy(xpath = "//*[@class='android.widget.TextView'][12]")
    public WebElement enUcuzFiyat;

}
