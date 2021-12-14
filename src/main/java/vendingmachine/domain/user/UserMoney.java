package vendingmachine.domain.user;

import vendingmachine.domain.product.Products;
import vendingmachine.validator.AmountValidator;

import static vendingmachine.constant.SystemMessage.ONE_THOUSAND_WON;

public class UserMoney {
    private int money;

    public UserMoney(String money) {
        AmountValidator.checkVendingMachineAmount(money);
        this.money = Integer.parseInt(money);
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
        while (money > ONE_THOUSAND_WON) {
            money -= ONE_THOUSAND_WON;
        }
        return money;
    }
}
