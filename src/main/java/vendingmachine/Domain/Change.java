package vendingmachine.Domain;

import vendingmachine.Constant.Coin;

import java.util.LinkedHashMap;


public class Change {

    private final LinkedHashMap<Coin, Integer> coins;

    public Change(LinkedHashMap<Coin, Integer> coins) {
        this.coins = coins;
    }

    public LinkedHashMap<Coin, Integer> getCoins() {
        return coins;
    }

    public LinkedHashMap<Coin, Integer> getChanges(int money) {
        LinkedHashMap<Coin, Integer> changes = new LinkedHashMap<>();

        for (Coin unit : this.coins.keySet()) {
            int count = getChangeCoinCount(unit, money);
            money -= unit.getAmount() * count;
            changes.put(unit, count);
        }

        return changes;
    }

    private int getChangeCoinCount(Coin unit, int money) {
        int count = 0;

        while (money >= unit.getAmount()) {
            if (coins.get(unit) > 0) {
                money -= unit.getAmount();
                count++;

                coins.put(unit, coins.get(unit) - 1);
                continue;
            }
            return count;
        }
        return count;
    }

}
