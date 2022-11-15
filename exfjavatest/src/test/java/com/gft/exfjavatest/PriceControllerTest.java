package com.gft.exfjavatest;

import com.gft.exfjavatest.Controller.PriceController;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PriceControllerTest {
    @Autowired
    PriceController priceController;

    @Test
    public void getLatestPriceFeed_WithMessage() {
        String message = "106, EUR/USD, 1.1000,1.2000,01-06-2020 12:01:01:001\n107, EUR/EGP, 1.1000,1.2000,01-06-2020 12:01:01:001";
        String response = this.priceController.getLatestPriceFeed(message);
        System.out.println("latest Price Feed: " + "\n" + response);
        Assert.assertNotNull(response.isEmpty());
        String testingValue = "106, EUR/USD,1.099000023841858,1.2010000476837157,01-06-2020 12:01:01:001\n" +
                "107, EUR/EGP,1.099000023841858,1.2010000476837157,01-06-2020 12:01:01:001";
        Assert.assertEquals(response, testingValue);

    }

    @Test
    public void getLatestPriceFeed_WithNullMessage() {
        String message = null;
        String response = this.priceController.getLatestPriceFeed(message);
        System.out.println("latest Price Feed: " + "\n" + response);
        Assert.assertNotNull(response.isEmpty());
    }

    @Test
    public void getLatestPriceFeed_WithWrongMessage() {
        String message = "106# EUR/USD, 1.1000#1.2000#01-06-2020 12:01:01:001\n107, EUR/EGP, 1.1000,1.2000,01-06-2020 12:01:01:001";
        String response = this.priceController.getLatestPriceFeed(message);
        String testingValue = "Something went wrong please check your CSV format.";
        Assert.assertEquals(response, testingValue);
    }

}
