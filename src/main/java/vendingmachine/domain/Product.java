package vendingmachine.domain;

public class Product {

    private final String name;
    private final int price;
    private int stock;

    public Product(final String name, final int price, final int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public boolean matchName(final String name) {
        if (this.name.equals(name)) {
            return true;
        }
        return false;
    }

    public int getPrice() {
        return price;
    }

    public boolean isBuyAble(final int insertAmount) {
        if (price > insertAmount) {
            return false;
        }
        return true;
    }

    public boolean isSoldOut() {
        if (stock == 0) {
            return true;
        }
        return false;
    }

    public void pullOut() {
        stock--;
    }
}