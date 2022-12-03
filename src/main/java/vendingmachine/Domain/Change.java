package vendingmachine.Domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static vendingmachine.Constant.Coin.*;

public class Change {

    private final HashMap<Integer, Integer> coins = new HashMap<>();

    Change(int money) {
        coins.put(COIN_10.getAmount(), 0);
        coins.put(COIN_50.getAmount(), 0);
        coins.put(COIN_100.getAmount(), 0);
        coins.put(COIN_500.getAmount(), 0);

        createCoins(money);
    }

    public HashMap<Integer, Integer> getCoins() {
        return coins;
    }

    private void createCoins(int money) {
        List<Integer> coinKeys = new ArrayList<>(coins.keySet());
        int randomCost = Randoms.pickNumberInList(coinKeys);
        int sum = getSum();

        while (sum != money) {
            if (sum + randomCost < money) {
                coins.put(randomCost, coins.get(randomCost));
                sum = getSum();
            }
            randomCost = Randoms.pickNumberInList(coinKeys);
        }
    }

    public int getSum() {
        List<Integer> coinKeys = new ArrayList<>(coins.keySet());
        int sum = 0;

        for (int key : coinKeys) sum += coins.get(key);

        return sum;
    }


}
