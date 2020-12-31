package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPage {

    public CheckoutPage(AndroidDriver<AndroidElement> driver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id="com.androidsample.generalstire:id/productPrice")
    public List<WebElement> productList;

    @AndroidFindBy(id="com.androidsample.generalstire:id/totalAmountLb1")
    public WebElement totalAmount;

    public List<WebElement> getProductList()
    {
         return productList;
    }


}
