package vendingmachine.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import camp.nextstep.edu.missionutils.Randoms;

public class Coins {
    private final HashMap<Integer, Integer> countCoin = new HashMap<>();

    public Coins() {
        initCoinMap();
    }

    public void generateRandomCoins(int money) {
        ArrayList<Integer> costList = createCostListWithinPrice(money);

        while (costList.size() > 1) {
            int picked = Randoms.pickNumberInList(costList);
            updateCountCoin(picked);
            money -= picked;
            updateCostListWith(costList, money);
        }
        countCoin.put(costList.get(0), money / 10);
    }

    public int getCountOfCoin(Coin coin) {
        return countCoin.get(coin.getAmount());
    }

    private void initCoinMap() {
        for (Coin coin : Coin.values()) {
            countCoin.put(coin.getAmount(), 0);
        }

    }

    private void updateCountCoin(int picked) {
        countCoin.put(picked, countCoin.get(picked) + 1);
    }

    //create arraylist and sort
    private ArrayList<Integer> createCostListWithinPrice(int money) {
        ArrayList<Integer> costList = new ArrayList<>();

        for (Coin coin : Coin.values()) {
            if (coin.getAmount() > money) {
                continue;
            }
            costList.add(coin.getAmount());
        }
        costList.sort(Collections.reverseOrder());

        return costList;
    }

    //maintain that the costList's items are under price
    private void updateCostListWith(ArrayList<Integer> costList, int price) {
        while (price < costList.get(0)) {
            costList.remove(0);
        }
    }
}
