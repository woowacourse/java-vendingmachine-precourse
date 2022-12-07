package vendingmachine.model;

import static vendingmachine.util.Constants.PRODUCT_NAME_INDEX;

import java.util.List;
import vendingmachine.util.Constants;
import vendingmachine.util.Util;
import vendingmachine.util.validator.ProductValidator;

public class Product {
    private final String productName;
    private final int productPrice;
    private final int productQuantity;

    private Product(List<String> productInfo) {
        this.productName = productInfo.get(Constants.PRODUCT_NAME_INDEX.getValue());
        this.productPrice = Integer.parseInt(productInfo.get(Constants.PRODUCT_PRICE_INDEX.getValue()));
        this.productQuantity = Integer.parseInt(productInfo.get(Constants.PRODUCT_QUANTITY_INDEX.getValue()));
    }

    public static Product from(String productInfo) {
        new ProductValidator().validate(productInfo);
        return new Product(Util.formatProductInfo(productInfo));
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productQuantity=" + productQuantity +
                '}';
    }
}
