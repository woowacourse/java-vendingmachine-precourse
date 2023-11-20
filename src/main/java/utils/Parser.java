package utils;

import vendingmachine.Product;

import java.util.LinkedHashMap;
import java.util.Map;

public class Parser {

    private static final String SEMI_COLON = ";";
    private static final String COMMA = ",";
    private static final String BRACKETS = "\\[|\\]";
    private static final String BLANK = "";
    public static int convertToInt(String amount){
        int parsedString = Integer.parseInt(amount);
        return parsedString;
    }

    public static Map<String, Product> convertToProductMap(String input) {
        String[] products = input.split(SEMI_COLON);
        Map<String, Product> productMap = new LinkedHashMap<>();
        for (String product : products) {
            String [] productInfo = product.replaceAll(BRACKETS, BLANK).split(COMMA);
            String productName = productInfo[0];
            int price = convertToInt(productInfo[1]);
            int quantity = convertToInt(productInfo[2]);
            Product savedProduct = new Product(productName, price, quantity);
            productMap.put(productName, savedProduct);
        }
        return productMap;
    }
}
