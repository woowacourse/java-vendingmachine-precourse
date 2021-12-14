package vendingmachine.repository;

public class Product {
    private String name;
    private int price;
    private int stock;

    public Product(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public int getPrice() {
        return this.price;
    }

    public int getStock() {
        return this.stock;
    }

    public void subtractStock() {
        this.stock--;
    }

    public boolean isLowerPrice(int comparedPrice) {
        return this.price < comparedPrice;
    }

    public boolean isOutOfStock() {
        return stock == 0;
    }

    public boolean isSameName(String input){
        return name.equals(input);
    }

}
