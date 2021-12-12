package vendingmachine.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import camp.nextstep.edu.missionutils.Randoms;

public class Coins {
    private final HashMap<Integer, Integer> coinTable = new HashMap<>();

    public Coins() {
        initializeCoins();
    }

    public void generateRandomCoins(int money) {
        ArrayList<Integer> costList = createCostList(money);
        costList.sort(Collections.reverseOrder());

        while (costList.size() > 1) {
            int picked = Randoms.pickNumberInList(costList);
            updateCountCoin(picked);
            money -= picked;
            updateCostListWith(costList, money);
        }
        countCoin.put(costList.get(0), money / 10);
    }

    public int getCoinCount(Coin coin) {
        return coinTable.get(coin.getAmount());
    }

    public boolean isIncluded(int coinCost) {
        for (int key : coinTable.keySet()) {
            if (key == coinCost) {
                return true;
            }
        }
        return false;
    }

    private void initializeCoins() {
        for (Coin coin : Coin.values()) {
            coinTable.put(coin.getAmount(), 0);
        }
    }

    private void countCoinOf(int coinCost, int plusCount) {
        isIncluded(coinCost);
        coinTable.put(coinCost, coinTable.get(coinCost) + plusCount);
    }

    // 금액 보다 작은 코인중 단위가 큰 코인 순서로 리스트 생성
    private ArrayList<Integer> createCostList(int money) {
        ArrayList<Integer> costList = new ArrayList<>();
        for (Coin coin : Coin.values()) {
            if (coin.getAmount() > money) {
                continue;
            }
            costList.add(coin.getAmount());
        }
        return costList;
    }

    //기준보다 높은 동전은 리스트에서 제거
    private void updateCostList(ArrayList<Integer> costList, int boundary) {
        while (costList.size() > 0 && boundary < costList.get(0)) {
            costList.remove(0);
        }
    }
}
