package practise.AppiumFramework;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import pageObjects.CheckoutPage;
import pageObjects.FormPage;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class Ecommerce_tc_4 extends base
{
   // public static void main(String[] args) throws MalformedURLException, InterruptedException {
    @Test
    public void TotalValidation() throws IOException, InterruptedException {

        startServer();
        AndroidDriver<AndroidElement> driver = base.capabilities("General-store.apk");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        FormPage formPage = new FormPage(driver);

        //formPage.nameField.sendKeys("Hello");
        formPage.getNameField().sendKeys("Hello");

        formPage.femaleOption.click();

        formPage.getcountrySelection().click();

        System.out.println("trying to find the Name field");

        Utilities u = new Utilities(driver);

        u.scrollToText("Argentina");

        CheckoutPage checkoutPage = new CheckoutPage(driver);



        driver.findElement(By.id("com.androidsample.generalstore:id/nameField"));

        driver.hideKeyboard();

        driver.findElement(By.xpath("//*[text()='Female']")).click();
        driver.findElement(By.id("android:id/text1")).click();

        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0)) "));

        driver.findElement(By.xpath("//*[text()='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore;id/btnletsShop")).click();

        driver.findElements(By.xpath("//*[text='ADD TO CART']")).get(0).click();
        driver.findElements(By.xpath("//*[text='ADD TO CART']")).get(1).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        Thread.sleep(4000);

        int count = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
        double sum = 0;
        for(int i=0;i<count;i++)
        {
            //String amount1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
            String amount1 = checkoutPage.productList.get(i).getText();

            double amount = getAmount(amount1);

            sum = sum + amount;
        }

        System.out.println(sum+"Sum of products");
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        String amount1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();

       // amount1 = amount1.substring(1);

        double amount1value = getAmount(amount1);

        String amount2 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();

        amount2 = amount2.substring(1);

        double amount2value = getAmount(amount2);

        double sumOfProducts = amount1value + amount2value;

        System.out.println(sumOfProducts+"sum of products");

        //String total = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLb1")).getText();
        String total = checkoutPage.totalAmount.getText();

        total = total.substring(1);

        double totalValue = Double.parseDouble(total);

        System.out.println(totalValue+"Total value of products");
       // Assert.assertEquals(sumOfProducts,totalValue);
        junit.framework.Assert.assertEquals(sumOfProducts,totalValue);

        //Mobile gestures

        WebElement checkbox = driver.findElement(By.className("android.widget.CheckBox"));
        TouchAction t = new TouchAction(driver);
        t.tap(TapOptions.tapOptions().withElement(element(checkbox))).perform();

       WebElement tc = driver.findElement(By.xpath("//*[@text='Please read our terms od conditions']"));
       t.longPress(LongPressOptions.longPressOptions().withElement(element(tc)).withDuration(Duration.ofSeconds(2))).release().perform();
       driver.findElement(By.id("android:id/button1")).click();
       driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();

       service.stop();
    }

    @BeforeTest
    public void killAllNodes() throws IOException, InterruptedException {
      Runtime.getRuntime().exec("taskkill /F /IM node.exe");
      Thread.sleep(3000);
    }

    public static double getAmount(String value)
    {
        value = value.substring(1);

        double amount2value = Double.parseDouble(value);

        return amount2value;
    }
}
