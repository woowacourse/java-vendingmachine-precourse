package vendingmachine;

public class Product {
    private static final String ERROR_NOT_STOCK = "상품의 재고가 없습니다.";
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
            throw new IllegalArgumentException(ERROR_NOT_STOCK);
        }
        amount--;
        return this.price;
    }

    public boolean existStock() {
        return this.amount > 0;
    }
}
