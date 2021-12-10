package vendingmachine.domain;

public class Product {
    private String name;
    private Price price;
    private Quantity quantity;

    private Product(String name, Price price, Quantity quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public static Product registerProduct(String name, Price price, Quantity quantity) {
        return new Product(name, price, quantity);
    }

    public String getName() {
        return name;
    }

    public boolean hasStock() {
        if (quantity.getQuantity() == 0) {
            return false;
        }
        return true;
    }

    public void takeOutInWarehouse() {
        quantity.takeOutInWarehouse();
    }

    public int getPrice() {
        return price.getPrice();
    }

    public int getQuantity() {
        return quantity.getQuantity();
    }
}
