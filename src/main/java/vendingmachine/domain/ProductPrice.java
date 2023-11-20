package vendingmachine.domain;

import vendingmachine.validators.ProductPriceValidator;

public class ProductPrice {

    private final int price;

    public ProductPrice(final int price) {
        this.price = price;
    }

    public static ProductPrice from(int price){
        ProductPriceValidator.validate(price);
        return new ProductPrice(price);
    }
}
