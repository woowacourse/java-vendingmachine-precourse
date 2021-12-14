package vendingmachine.vo;

public class Product {
    private String name;
    private Integer price;
    private Integer quantity;

    public Product(String name, Integer price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public boolean sell() {
        if (quantity < 1) {
            return false;
        }

        quantity--;
        return true;
    }

    public String getName() {
        return this.name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getPrice() {
        return price;
    }
}
