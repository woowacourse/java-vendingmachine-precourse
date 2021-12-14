package vendingmachine.service;

import vendingmachine.domain.Change;
import vendingmachine.domain.Coin;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class CoinService {
    private final MessageService messageService = new MessageService();
    private static LinkedHashMap<Integer, Integer> coinCountMap = new LinkedHashMap<>();
    private static List<Integer> coinAmountList = new ArrayList<>();
    private static Change change = Change.getInstance();

    public CoinService() {
        initCoinAmount();
        initCoinCount();
    }

    public void makeCoins(int holding) {
        while (true) {
            int selected = Randoms.pickNumberInList(coinAmountList);
            addCoin(selected);
            int pickedSum = getSum();
            if (isSamePrice(pickedSum, holding)) {
                messageService.printCoinCount(coinCountMap);
                break;
            } else if (pickedSum > holding) {
                initCoinCount();
            }
        }
    }

    public LinkedHashMap<Integer, Integer> getLastChanges() {
        LinkedHashMap<Integer, Integer> result = new LinkedHashMap<>();
        int remain = change.getAmount();
        for (int amount : coinAmountList) {
            int count = coinCountMap.get(amount);
            if (count > 0 && remain > 0 && remain % amount == 0) {
                int usedCount = getUsedCoinCount(amount, count, remain);
                remain -= usedCount * amount;
                result.put(amount, usedCount);
            }
        }
        return result;
    }

    private int getUsedCoinCount(int amount, int count, int remain) {
        if (remain / amount >= count) {
            return count;
        }
        return remain / amount;
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

    private boolean isSamePrice(int sum, int holding) {
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
