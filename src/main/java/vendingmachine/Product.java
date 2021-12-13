package vendingmachine;

public class Product {
    private String name;
    private int price;
    private int number;

    public Product(String name, int price, int number) {
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public int getPrice() {
        return price;
    }

    public boolean isInclude(String input) {
        if (input.contains(name)) {
            return true;
        }
        return false;
    }
}
