package com.qa.pages.strategy;

import java.util.Map;

public interface PaymentOption {
    void fillPaymentDetails(Map<String, String> paymentDetails);
}
