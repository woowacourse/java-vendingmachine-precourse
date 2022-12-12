package vendingmachine;

public class Product {
    private final String name;
    private final int price;
    private int amount;

    public Product(String name, String price, String amount) {
        this.name = name;
        this.price = Integer.parseInt(price);
        this.amount = Integer.parseInt(amount);
    }

    public void sellProduct() {
        if (!isEmpty()) {
            amount--;
        }
    }

    private boolean isEmpty() {
        return amount == 0;
    }

    public String askItsName() {
        return new String(name);
    }

    public int askItsPrice() {
        return price;
    }

    public int askStockLeft() {
        return amount;
    }

}
