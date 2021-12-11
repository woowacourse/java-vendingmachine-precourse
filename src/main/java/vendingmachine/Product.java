package vendingmachine;

public class Product {
    String name;
    int price;
    int amount;

    public Product(String name, int price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public int sell() {
        if (this.amount <= 0) {
            throw new IllegalArgumentException("물건을 판매할 수 없습니다.");
        }
        amount--;
        return this.price;
    }
}
