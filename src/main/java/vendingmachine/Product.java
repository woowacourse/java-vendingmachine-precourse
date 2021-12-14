package vendingmachine;

public class Product {

    private static final int SOLD_OUT = 0;

    private String name;
    private Integer price;
    private Integer quantity;

    public Product(String name, Integer price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public boolean soldOut() {
        return this.quantity == SOLD_OUT;
    }

    public void sell() {
        this.quantity--;
    }

    public boolean matchProductName(String wantedProduct) {
        return this.name.equals(wantedProduct);
    }
}
