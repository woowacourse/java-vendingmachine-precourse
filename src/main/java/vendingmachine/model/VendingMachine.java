package vendingmachine.model;

import vendingmachine.Coin;

import java.util.Map;
import java.util.Map.Entry;

public class VendingMachine {
    private Products products;
    private Money changes;
    private int payment;

    public VendingMachine(int totalMoney, Products products) {
        this.changes = new Money(totalMoney);
        this.products = products;
    }

    public void pay(int payment) {
        this.payment = payment;
    }

    public boolean isExit() {
        return products.getMinPrice() > payment || products.isAllSoldOut();
    }

    public void buyProduct(String name) {
        try {
            System.out.println("투입 금액: "+payment);
            int productPrice = products.buyProduct(name, payment);
            payment -= productPrice;

        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getChangeString() {
        Map<Coin, Integer> coins = changes.getChanges(payment);
        StringBuilder stringBuilder = new StringBuilder("잔돈\n");
        for(Entry<Coin, Integer> coin: coins.entrySet()) {
            if(coin.getValue() == 0) {
                continue;
            }
            stringBuilder.append(coin.getKey().getAmount())
                    .append(" - ")
                    .append(coin.getValue())
                    .append("개\n");
        }
        return stringBuilder.toString();
    }
}
