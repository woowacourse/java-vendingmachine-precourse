package vendingmachine.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.domain.Product;

public class InputParsingUtility {
    public List<Product> parsing(String productNameAndPriceAndStocks) {
        List<String> streamProductInformation = Arrays.stream(productNameAndPriceAndStocks.split(";")).collect(Collectors.toList());
        List<Product> results = new ArrayList<>();
        for (String productInformation : streamProductInformation) {
            String removeProductInformation = removeBracket(productInformation);
            String[] productNameAndPriceAndQuantity = removeProductInformation.split(",");
            String productName = productNameAndPriceAndQuantity[0];
            int price = Integer.parseInt(productNameAndPriceAndQuantity[1]);
            int quantity = Integer.parseInt(productNameAndPriceAndQuantity[2]);
            results.add(new Product(productName, price, quantity));
        }
        return results;
    }

    private String removeBracket(String productInformation) {
        return productInformation.substring(1, productInformation.length() - 1);
    }
}
