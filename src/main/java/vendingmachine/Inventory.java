package vendingmachine;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Inventory {
    private Message message = new Message();
    private Parser parser = new Parser();
    private LinkedHashMap<Integer, Integer> coinCountMap = new LinkedHashMap<>();
    private List<Integer> coinAmountList = new ArrayList<>();

    Inventory() {
        initCoinAmount();
        initCoinCount();
    }

    public void makeCoins(int holding) {
        while (true) {
            int selected = Randoms.pickNumberInList(coinAmountList);
            addCoin(selected);
            int sum = getSum();
            if (isSame(sum, holding)) {
                String output = parser.parseHolding(coinCountMap);
                message.printCoinCount(output);
                break;
            } else if (sum > holding) {
                initCoinCount();
            }
        }
    }

    private void initCoinAmount() {
        for (Coin coin : Coin.values()) {
            coinAmountList.add(coin.getAmount());
        }
    }

    private void initCoinCount() {
        coinCountMap.clear();
        for (int key : coinAmountList) {
            coinCountMap.put(key, 0);
        }
    }

    private boolean isSame(int sum, int holding) {
        if (sum == holding) {
            return true;
        }
        return false;
    }

    private void addCoin(int value) {
        coinCountMap.put(value, coinCountMap.get(value) + 1);
    }

    private int getSum() {
        int result = 0;
        for (int key : coinCountMap.keySet()) {
            result += key * coinCountMap.get(key);
        }
        return result;
    }
}
