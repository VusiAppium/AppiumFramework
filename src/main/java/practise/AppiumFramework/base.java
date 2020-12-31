package practise.AppiumFramework;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base
{
   public static AppiumDriverLocalService service;
   public static AndroidDriver<AndroidElement> driver;

    public AppiumDriverLocalService startServer()
    {
        boolean flag = checkIfServerIsRunning(4723);

        if(!flag) {
            service = AppiumDriverLocalService.buildDefaultService();
            service.start();
        }

        return service;
    }

    public static boolean checkIfServerIsRunning(int port)
    {
        boolean isServerRunning = false;
        ServerSocket serverSocket;

        try
        {
            serverSocket = new ServerSocket();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
            isServerRunning = true;
        } finally{
            serverSocket = null;
        }

        return isServerRunning;

    }

    public static void startEmulator() throws InterruptedException, IOException {
         Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Users\\abvn237\\IdeaProjects\\Package Explorer \\AppiumFramework\\src\\main\\java\\resources\\startEmulator.bat");
         Thread.sleep(6000);
    }

    public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+" \\Users\\abvn237\\IdeaProjects\\Package Explorer \\AppiumFramework\\src\\main\\java\\practise\\AppiumFramework\\global.properties");


        Properties prop = new Properties();

        //AndroidDriver<AndroidElement> driver;

        prop.load(fis);

       // prop.get(appName);

        File f = new File("/Users/abvn237/IdeaProjects/Package Explorer /Tutorials/src/");
        File fs = new File(f, (String) prop.get(appName));


        DesiredCapabilities cap = new DesiredCapabilities();
        //String device = (String) prop.get("device");
        String device = System.getProperty("deviceName")

        if(device.contains("emulator"))
        {
            startEmulator();
        }
        /*if(prop.get("device").equals("emulator"))
        {

        }*/

        //cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2 XL API 28");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        cap.setCapability(MobileCapabilityType.APP,f.getAbsolutePath());
        //cap.setCapability(MobileCapabilityType.PLATFORM,Platform.ANDROID);
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomation2");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
        return driver;
    }

    public static void getScreenshot(String s) throws IOException {
        File scrfile = (File) driver.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"\\"+s+".png"));
    }
}
