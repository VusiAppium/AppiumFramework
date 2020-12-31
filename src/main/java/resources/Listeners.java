package resources;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import practise.AppiumFramework.base;

import java.io.IOException;

public class Listeners implements ITestListener
{
    @Override
    public void onTestStart(ITestResult result)
    {

    }

    @Override
    public void onTestSuccess(ITestResult result)
    {

    }

    @Override
    public void onTestFailure(ITestResult result)
    {
       String s = result.getName();

       try
       {
           base.getScreenshot(s);
       } catch (IOException e) {
           e.printStackTrace();
       }
        //ba
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result)
    {

    }

    @Override
    public void onTestSkipped(ITestResult result)
    {

    }

    @Override
    public void onStart(ITestContext context)
    {

    }

    @Override
    public void onFinish(ITestContext context)
    {

    }
}
