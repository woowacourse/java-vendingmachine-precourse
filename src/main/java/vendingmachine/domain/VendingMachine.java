package vendingmachine.domain;

import java.util.HashMap;
import java.util.Map;
import vendingmachine.Coin;

public class VendingMachine {

    private final Map<Coin, Integer> coins;

    public VendingMachine(Map<Coin, Integer> coins) {
        this.coins = coins;
    }

    public static VendingMachine createByMoney(Money money) {

        return new VendingMachine(new HashMap<>());
    }
}
