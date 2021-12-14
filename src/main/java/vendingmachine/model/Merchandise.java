package vendingmachine.model;

public class Merchandise {
    private final String name;
    private final int price;
    private int inventory;

    public Merchandise(String name, int price, int inventory) {
        this.name = name;
        this.price = price;
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getInventory() {
        return inventory;
    }

    public void decreaseInventory() {
        inventory--;
    }
}
