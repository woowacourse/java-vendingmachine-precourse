package vendingmachine.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Changes {
    private final HashMap<Integer, Integer> changes = new HashMap<>();

    public Changes() {
        initChanges();
    }

    private void initChanges() {
        for (Coin coin : Coin.values()) {
            changes.put(coin.getAmount(), 0);
        }
    }

    public void makeChanges(HashMap<Integer, Integer> coinTable, Money money) {
        int totalChanges = 0;
        Object[] sortedCoin = coinTable.keySet().toArray();
        Arrays.sort(sortedCoin, Collections.reverseOrder());
        for (Object coin : sortedCoin) {
            while (money.getCost() >= totalChanges + (Integer) coin && coinTable.get((Integer) coin) > changes.get(coin)) {
                totalChanges += (Integer) coin;
                changes.put((Integer) coin, changes.get(coin)+1);
            }
        }
    }

    public HashMap<Integer, Integer> getChanges() {
        return changes;
    }
}
