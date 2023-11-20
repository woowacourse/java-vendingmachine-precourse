package vendingmachine.domain;

import vendingmachine.validators.ProductPriceValidator;

public class Product {
    private final String name;
    private final ProductPrice price;

    private Product(final String name, final int price) {
        this.name = name;
        this.price = ProductPrice.from(price);
    }

    public static Product of (String name, int price){
        return new Product(name, price);
    }

}
