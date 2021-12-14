package vendingmachine.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import camp.nextstep.edu.missionutils.Randoms;

public class CoinBox {
    private final HashMap<Integer, Integer> coinTable = new HashMap<>();

    public CoinBox() {
        initializeCoiBox();
    }

    public void generateRandomCoinBox(int money) {
        ArrayList<Integer> costList = createCostList(money);
        costList.sort(Collections.reverseOrder());

        while (costList.size() > 1) {
            int picked = Randoms.pickNumberInList(costList);
            countCoinOf(picked, 1);
            money -= picked;
            updateCostList(costList, money);
        }

        if (money > 0) {
            countCoinOf(costList.get(0), money / costList.get(0));
        }
    }

    public int getCoinCount(Coin coin) {
        return coinTable.get(coin.getAmount());
    }

    public int getCoinCount(int coinCost) {
        if (isIncluded(coinCost)) {
            return coinTable.get(coinCost);
        }
        return -1;
    }

    public int getValueOfCoinBox() {
        int money = 0;
        for (int coinCost : coinTable.keySet()) {
            money += getCoinCount(coinCost) * coinCost;
        }
        return money;
    }

    public boolean isIncluded(int coinCost) {
        for (int key : coinTable.keySet()) {
            if (key == coinCost) {
                return true;
            }
        }
        return false;
    }

    public CoinBox getAvailableChange(int change) {   //change: 잔돈
        ArrayList<Integer> list = createCostList(change);
        list.sort(Collections.reverseOrder());
        CoinBox returnCoins = new CoinBox();

        for (int coinCost : list) {
            if (change < coinCost) {
                continue;
            }
            int coinAvailable = getCoinAvailable(coinCost, change);
            returnCoins.countCoinOf(coinCost, coinAvailable);
            countCoinOf(coinCost, -coinAvailable);
            change -= coinAvailable * coinCost;
        }
        return returnCoins;
    }

    private int getCoinAvailable(int coinCost, int money) {
        return Math.min(money / coinCost, getCoinCount(coinCost));
    }

    private void initializeCoiBox() {
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
