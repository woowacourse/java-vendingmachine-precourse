package vendingmachine.Util;

import vendingmachine.Domain.Product;

import java.util.ArrayList;
import java.util.List;

public class Caster {

    public List<Product> toProducts(String userInput) {
        List<Product> products = new ArrayList<>();

        for (String productInfo : userInput.split(";")) {
            String name = getProductName(productInfo);
            int cost = getProductCost(productInfo);
            int count = getProductCount(productInfo);

            products.add(new Product(name, cost, count));
        }

        return products;
    }

    private String getProductName(String productInfo) {
        return productInfo
                .split(",")[0]
                .substring(1);
    }

    private int getProductCost(String productInfo) {
        return Integer.parseInt(productInfo
                .split(",")[1]);
    }

    private int getProductCount(String productInfo) {
        String count = productInfo.split(",")[2];
        count = count.substring(0, count.length() - 1);

        return Integer.parseInt(count);
    }

}
