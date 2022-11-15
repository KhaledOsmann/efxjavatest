package com.gft.exfjavatest.Service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PriceService {

    private final double sellPrice = -0.001;
    private final double buyPrice = 0.001;

    public String receivingMessage(String message) {
        //will split message by newline.
        List<String> messageList = splitUtil(message, "\\R");
        List<String> latestPriceFeed = new ArrayList<>();

        if (!message.isEmpty()) {
            try {
                for (String currentMessage : messageList) {
                    //split message by comma separated.
                    List<String> commaSplitList = splitUtil(currentMessage, ",");

                    //process add commission
                    String bid = subtractCommission(commaSplitList.get(2));
                    String ask = addCommission(commaSplitList.get(3));

                    //update price feed with the latest commission.
                    commaSplitList.set(2, bid);
                    commaSplitList.set(3, ask);

                    String response = concatenatePriceList(commaSplitList, ",");
                    latestPriceFeed.add(response);
                }
            } catch (Exception ex) {
                System.out.println(ex);
                return "Something went wrong please check your CSV format.";
            }
        }

        //return latest price feed.
        return concatenatePriceList(latestPriceFeed, "\n");
    }


    private List<String> splitUtil(String message, String splitType) {
        return Arrays.asList(message.split(splitType));
    }

    private String addCommission(String ask) {
        return String.valueOf(buyPrice + Float.parseFloat(ask));
    }

    private String subtractCommission(String bid) {
        return String.valueOf(sellPrice + Float.parseFloat(bid));
    }

    private String concatenatePriceList(List<String> commaSplittedMessage, String concatenatType) {
        String response = "";
        if (!commaSplittedMessage.isEmpty()) {
            response = String.join(concatenatType, commaSplittedMessage);
        }
        return response;
    }

}