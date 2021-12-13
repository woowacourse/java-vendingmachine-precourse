package vendingmachine.model;

import vendingmachine.Coin;

import java.util.Map;
import java.util.Map.Entry;

public class VendingMachine {
    private Products products;
    private Money changes;

    public VendingMachine(int totalMoney, Products products) {
        this.changes = new Money(totalMoney);
        this.products = products;
    }

    public String buyProduct(String name, int payment) {
        try {
            products.buyProduct(name, payment);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        Map<Coin, Integer> coinMap = changes.getChanges(payment);
        return getChangeString(coinMap);
    }

    private String getChangeString(Map<Coin, Integer> changes) {
        StringBuilder stringBuilder = new StringBuilder("잔돈\n");
        for(Entry<Coin, Integer> change: changes.entrySet()) {
            stringBuilder.append(change.getKey().toString())
                    .append("\n - ")
                    .append(change.getValue())
                    .append("개\n");
        }
        return stringBuilder.toString();
    }
}
