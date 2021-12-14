package vendingmachine.domain;

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

    public boolean isSameName(String input) {
        if (name.equals(input)) {
            return true;
        }
        return false;
    }

    public void decreaseNumber() {
        number -= 1;
    }

    public boolean isEmpty() {
        if (number == 0) {
            return true;
        }
        return false;
    }
}
