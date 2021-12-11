package vendingmachine.management;

import vendingmachine.management.validation.CheckCommodityName;
import vendingmachine.management.validation.CheckCommodityPrice;
import vendingmachine.management.validation.CheckCommodityQuantity;

public class Commodity {
    private String name;
    private int price;
    private int quantity;
    
    public Commodity(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
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
