package vendingmachine.domain.VendingMachine;

import vendingmachine.domain.Items;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private final Items items;
    private final Wallet wallet;

    public VendingMachine(Wallet wallet, Items items) {
        this.wallet = wallet;
        this.items = items;
    }

    public String getCoinsMessage() {
        return wallet.getMessage();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public boolean containsAvailableItem(int money) {
        return items.containsAvailableItem(money);
    }

    public int buy(ItemName itemName, int money) {
        Item item = items.find(itemName);
        if(item.isEmpty() || !item.isAvailable(money)) {
            throw new IllegalArgumentException("[ERROR] 구매할 수 없습니다.");
        }
        item.reduce();
        return money - item.getPrice();
    }
}
