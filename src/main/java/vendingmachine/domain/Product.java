package vendingmachine.domain;

import vendingmachine.validators.ProductValidator;

public class Product {
    private final String name;
    private final int price;

    private Product(final String name, final int price) {
        this.name = name;
        this.price = price;
    }

    public static Product of (String name, int price){
        ProductValidator.validate(price);
        return new Product(name, price);
    }

}
