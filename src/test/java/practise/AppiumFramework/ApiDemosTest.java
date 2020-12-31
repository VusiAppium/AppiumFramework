package practise.AppiumFramework;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.jupiter.api.Test;
import org.testng.annotations.DataProvider;
import pageObjects.HomePage;
import pageObjects.Preferences;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class ApiDemosTest extends base
{
    @Test (dataProvider="InputData",dataProviderClass="TestData.class")
    public void ApiDemos(String input) throws IOException, MalformedURLException
    {
        service = startServer();
        AndroidDriver<AndroidElement> driver = Hybridbase.capabilities("real");

        HomePage homePage = new HomePage(driver);

        homePage.Preferences.click();

        Preferences p = new Preferences(driver);

        p.dependencies.click();
        p.buttons.get(1).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        service.stop();
        //driver.findElementByXPath("//android.widget.TextView[@Text='Preference']").click();
        //driver.findElementByXPath("//android.widget.TextView[@Text='Preference']").click();
        //driver.findElementByXPath("//android.widget.TextView[@Text='Preference dependencies']").click();
        //driver.findElementById("android:id/checkbox").click();


        //h.Preferences.click();
        //Preferences p = new Preferences(driver);
        //p.dependencies.click();
        //driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
        //driver.findElementByClassName("android.widget.EditText").sendKeys("hello");
        //driver.findElementsByClassName("android.widget.Button").get(2).click();

       // p.buttons.get(1).click();
    }

    @DataProvider(name = "InputData")
    public void getDataForEditField()
    {
       Object [][] obj = new Object[][]
                {
                        {"hello"},{"@#$%"}
                };
    }
}
