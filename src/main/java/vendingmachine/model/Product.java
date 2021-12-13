package vendingmachine.model;

import java.util.List;

public class Product {
    private static final int NAME_INDEX = 0;
    private static final int PRICE_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int REDUCE_BY_ONE = 1;

    private final String name;
    private final int price;
    private int quantity;

    public Product(List<String> list) {
        name = list.get(NAME_INDEX);
        price = Integer.parseInt(list.get(PRICE_INDEX));
        quantity = Integer.parseInt(list.get(QUANTITY_INDEX));
    }

    public void popProduct() {
        quantity -= REDUCE_BY_ONE;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
