package com.qa.test.command;

import com.qa.DriverUtil.BaseTest;
import com.qa.pages.command.AdminProHomePage;
import com.qa.pages.command.CommandPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CommandPatternTest extends BaseTest {
    private AdminProHomePage adminProHomePage;

    @BeforeClass
    public void BeforeClass() {
        adminProHomePage = new AdminProHomePage(driver);
    }

    @Test
    public void commandValidatorTest() {
        adminProHomePage.goTo();
        adminProHomePage.returnValidators().stream().map(CommandPage::execute).forEach(Assert::assertTrue);
    }

}
