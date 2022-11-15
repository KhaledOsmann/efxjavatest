package com.gft.exfjavatest.Controller;

import com.gft.exfjavatest.Service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PriceController {

    @Autowired
    PriceService priceService;

    @RequestMapping(value = "/getLatestPriceFeed", method = RequestMethod.POST)
    public String getLatestPriceFeed(@RequestBody String message) {
        String response = "";
        try {
            response = priceService.receivingMessage(message);
        } catch (Exception ex) {
            System.out.println(ex);
            return "Something went wrong please check your CSV format.";
        }

        return response;

    }
}