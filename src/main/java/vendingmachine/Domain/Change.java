package vendingmachine.Domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class Change {

    private final HashMap<Integer, Integer> coins;

    public Change(HashMap<Integer, Integer> coins) {
        this.coins = coins;
    }

    public HashMap<Integer, Integer> getCoins() {
        return coins;
    }

    public HashMap<Integer, Integer> getChanges(int money) {
        HashMap<Integer, Integer> changes = new HashMap<>();

        List<Integer> coinUnits = new ArrayList<>(this.coins.keySet());
        coinUnits.sort(Collections.reverseOrder());

        for (int unit : coinUnits) {
            int count = getChangeCoinCount(unit, money);
            money -= unit * count;
            changes.put(unit, count);
        }

        return changes;
    }

    private int getChangeCoinCount(int unit, int money) {
        int count = 0;

        while (money >= unit) {
            if (coins.get(unit) > 0) {
                money -= unit;
                count++;

                coins.put(unit, coins.get(unit) - 1);
                continue;
            }
            return count;
        }
        return count;
    }

}
