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

    public boolean canBuyCheapestProduct(Products products) {
        return money >= products.getCheapestPrice();
    }

}
