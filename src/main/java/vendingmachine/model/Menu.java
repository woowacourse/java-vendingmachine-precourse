package vendingmachine.model;

import java.util.List;

public class Menu {
    private final String name;
    private final int price;
    private int stock;

    public Menu(String name, String price, String stock) {
        this.name = name;
        this.price = Integer.parseInt(price);
        this.stock = Integer.parseInt(stock);
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int currStock) {
        this.stock = currStock;
    }
}
