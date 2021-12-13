package vendingmachine.model;

public class Merchandise {
    private String name;
    private int price;
    private int inventory;

    public Merchandise(String name, int price, int inventory) {
        this.name = name;
        this.price = price;
        this.inventory = inventory;
    }
}
