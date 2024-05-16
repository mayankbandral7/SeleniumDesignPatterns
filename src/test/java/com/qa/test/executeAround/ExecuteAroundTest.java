package com.qa.test.executeAround;

import com.google.common.util.concurrent.Uninterruptibles;
import com.qa.DriverUtil.BaseTest;
import com.qa.pages.executeAround.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ExecuteAroundTest extends BaseTest {

    private HomePage homePage;

    @BeforeClass
    public void beforeClass() {
        homePage = new HomePage(driver);
    }

    @Test(dataProvider = "createTestData", dataProviderClass = ExecuteAroundTest.class)
    public void testFunctionality(Map<String, String> testData) {
        homePage.goTo();
        homePage.setFrameA(frameA -> frameA.fillUserDetails(testData));
        homePage.setFrameB(frameB -> frameB.fillUserDetails(testData));
        homePage.setFrameC(frameC -> frameC.fillUserDetails(testData));
        Uninterruptibles.sleepUninterruptibly(3000, TimeUnit.MILLISECONDS);
    }

    @DataProvider
    public Object[] createTestData() {
        Map<String, String> testData = new HashMap<>();
        testData.put("firstName", "Mayank");
        testData.put("lastName", "Bandral");
        testData.put("address", "Jammu");
        return new Object[]{testData};
    }

}
