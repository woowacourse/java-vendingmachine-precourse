package vendingmachine;

import vendingmachine.exception.NotEnoughStockException;

public class Product {

    public static final int MINIMUM_SELLABLE_STOCK = 1;

    private String name;

    private int price;

    private int stockQuantity;

    public Product(String name, int price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public void sell() {
        if (stockQuantity < MINIMUM_SELLABLE_STOCK) {
            throw new NotEnoughStockException(ErrorMessage.NOT_ENOUGH_STOCK.getCompleteMessage());
        }
        this.stockQuantity--;
    }

    public boolean isSoldOut() {
        return stockQuantity == 0;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public int getStockQuantity() {
        return this.stockQuantity;
    }

}
