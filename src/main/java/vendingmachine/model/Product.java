package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import vendingmachine.utils.Symbol;

public class Product {

    private final Name name;
    private final Price price;
    private final Count count;

    public Product(final String name, final int price, final int count) {
        this.name = new Name(name);
        this.price = new Price(price);
        this.count = new Count(count);
    }

}
