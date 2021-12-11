package vendingmachine.domain;

import java.util.List;

public class Money {
    private int money;
    private static final Money instance = new Money();

    private Money() {
    }

    public void storeMoney(int money) {
        this.money = money;
    }

    public static Money getInstance() {
        return instance;
    }

    public void minusMoney(String productName) {
        List<Product> products = ProductRepository.getInstance().getProducts();
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                money -= product.getCost();
            }
        }
    }

    public int getMoney() {
        return money;
    }
}
