package vendingmachine.domain.user;

import vendingmachine.domain.product.Products;

public class UserMoney {
    private int money;

    public UserMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void reduce(int price) {
        money -= price;
    }

    public boolean canNotBuyCheapestProduct(Products products) {
        return money < products.getCheapestPrice();
    }

    public int reduceMoney() {
        while (money > 1000) {
            money -= 1000;
        }
        return money;
    }
}
