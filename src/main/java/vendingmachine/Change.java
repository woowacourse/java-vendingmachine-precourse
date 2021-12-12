package vendingmachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Change {
    private HashMap<Integer, Integer> coinCountList = new HashMap<>();
    private List<Integer> coinAmountList = new ArrayList<>();

    Change() {
        initCoinAmount();
    }

    public void makeCoins(int holding) {
        while (true) {
            int selected = Randoms.pickNumberInList(coinAmountList);
            addCoin(selected);
            int sum = getSum();
            if (isSame(sum, holding)) {
                System.out.println(coinCountList.toString());
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
        coinCountList.clear();
    }

    private boolean isSame(int sum, int holding) {
        if (sum == holding) {
            return true;
        }
        return false;
    }

    private void addCoin(int value) {
        int originCount = coinCountList.getOrDefault(value, 0);
        coinCountList.put(value, originCount + 1);
    }

    private int getSum() {
        int result = 0;
        for (int key : coinCountList.keySet()) {
            result += key * coinCountList.get(key);
        }
        return result;
    }
}
