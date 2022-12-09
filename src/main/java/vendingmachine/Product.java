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

    public boolean isEmpty() {
        return amount == 0;
    }

    public String askName() {
        return new String(name);
    }

    public int askPrice() {
        return price;
    }
    public int askStockLeft(){
        return amount;
    }

}
