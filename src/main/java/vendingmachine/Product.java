package vendingmachine;

public class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        // instanceof operator runs null check.
        // But add null check explicitly in if statement
        if (other == null || !(other instanceof Product)) {
            return false;
        }

        return this.hashCode() == other.hashCode();
    }
}
