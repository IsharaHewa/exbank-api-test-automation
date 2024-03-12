package com.api.api;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    //Extent report creation
    protected static ExtentReports extentReports;
    protected  ExtentTest extentTest;
    @BeforeSuite(alwaysRun = true)
    public void setupSuite(){
        extentReports = new ExtentReports();
        extentReports.attachReporter(new ExtentSparkReporter(("./extentReport.html")));
    }
    @AfterMethod
    public void extendReporting(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.pass(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.skip(result.getThrowable());
        }

    }
    @AfterSuite
    public void AfterSuite() {
        extentReports.flush();
    }
}
