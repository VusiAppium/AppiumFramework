package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FormPage {

    public FormPage(AppiumDriver driver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement nameField;

    @AndroidFindBy(xpath = "//*[@text='Female']")
    public WebElement femaleOption;

    @AndroidFindBy(xpath = "android:id/text1")
    private WebElement countrySelection;

    public WebElement getNameField()
    {
        System.out.println("trying to find the Name field");
        return nameField;
    }

    public WebElement getcountrySelection()
    {
        System.out.println("Selecting the country");
        return countrySelection;
    }

    public WebElement getFemaleOption()
    {
        System.out.println("trying to find the Name field");
        return femaleOption;
    }

}
