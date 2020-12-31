package practise.AppiumFramework;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Hybridbase
{
    public static AndroidDriver<AndroidElement> capabilities(String device) throws MalformedURLException
    {
        AndroidDriver<AndroidElement> driver;

        File appDir = new File("src");
        File app = new File(appDir,"ApiDemos-debug.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        if(device.equals("emulator"))
        {
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"RahulEmaulator");
        }
        else if(device.equals("real"))
        {
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Device");
        }

        capabilities.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        return driver;
    }
}
