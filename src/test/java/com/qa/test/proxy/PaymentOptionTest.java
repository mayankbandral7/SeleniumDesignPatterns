package com.qa.test.proxy;

import com.qa.DriverUtil.BaseTest;

import com.qa.pages.proxy.CreditCard;
import com.qa.pages.proxy.NetBanking;
import com.qa.pages.proxy.PaymentOption;
import com.qa.pages.proxy.PaymentScreen;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class PaymentOptionTest extends BaseTest {

    private PaymentScreen paymentScreen;

    @BeforeClass
    public void BeforeClass() {
        paymentScreen = new PaymentScreen(driver);
    }

    @Test(dataProvider = "dataProvider")
    public void fillUserDetails(PaymentOption paymentOption, Map<String, String> paymentDetails) {
        paymentScreen.goTo();
        paymentScreen.userDetails("Mayank", "Bandral", "mayankbandral@hotmail.com");
        paymentScreen.setPaymentOption(paymentOption);
        paymentScreen.fillPaymentFields(paymentDetails);
        String orderNumber = paymentScreen.getOrder();
        System.out.println("OrderComponentReal Number :" + orderNumber);
        System.out.println("Testing VC in images");
    }

    @DataProvider
    public Object[][] dataProvider() {
        Map<String, String> creditCardDetails =
                Map.of("creditCardNumber", "123456789", "year", "1994", "cvv", "123");

        Map<String, String> netBankingDetails =
                Map.of("bankName", "WELLS FARGO", "accNumber", "123456", "pinNumber", "12");

        return new Object[][]{
                {new NetBanking(), netBankingDetails},
                {new CreditCard(), creditCardDetails}
        };
    }


}
