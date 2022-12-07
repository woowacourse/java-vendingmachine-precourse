package vendingmachine.model;

import java.util.Arrays;
import java.util.List;
import vendingmachine.util.Util;
import vendingmachine.util.validator.ProductValidator;

public class Product {
    private final String productName;
    private final int productPrice;
    private final int productQuantity;

    private Product(List<String> productInfo) {
        this.productName = productInfo.get(0);
        this.productPrice = Integer.parseInt(productInfo.get(1));
        this.productQuantity = Integer.parseInt(productInfo.get(2));
    }

    public static Product from(String productInfo) {
        new ProductValidator().validate(productInfo);
        return new Product(splitByComma(productInfo));
    }

    private static List<String> splitByComma(String productInfo) {
        return Arrays.asList(Util.removeSpace(productInfo).split(","));
    }
}
