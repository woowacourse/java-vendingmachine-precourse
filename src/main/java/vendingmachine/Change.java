package vendingmachine;

import java.util.*;

public class Change {

    private final Map<String, Integer> changes = new HashMap<>();

    public Change() {
        changes.put("COIN_500", 0);
        changes.put("COIN_100", 0);
        changes.put("COIN_50", 0);
        changes.put("COIN_10", 0);
    }

    public Map<Integer, Integer> getChanges(Map<String, Integer> coins, int inputMoney) {
        Map<Integer, Integer> change = new LinkedHashMap<>();
        Coin[] coinUnits = Coin.values();

        for (Coin coin : coinUnits) {
            int machineCoinCount = coins.get("Coin_" + coin.getAmount());

            if(machineCoinCount != 0){
                int coinCount = inputMoney / coin.getAmount();
                if(coinCount > machineCoinCount){
                    coinCount = machineCoinCount;
                    inputMoney = inputMoney - (coin.getAmount() * machineCoinCount);
                    change.put(coin.getAmount(), coinCount);
                }
            }
        }

        return change;
    }

    private void makeChange(int afterDealMoney) {
        int tempAfterDealMoney = afterDealMoney;
        tempAfterDealMoney = saveCoins(tempAfterDealMoney, 500);
        tempAfterDealMoney = saveCoins(tempAfterDealMoney, 100);
        tempAfterDealMoney = saveCoins(tempAfterDealMoney, 50);
        saveCoins(tempAfterDealMoney, 10);
    }

    private int saveCoins(int afterDealMoney, int coin) {
        String coinUnit = "COIN_" + coin;
        int leftCoin = Coin.valueOf(coinUnit).getNumber();
        if (leftCoin >= 1 && afterDealMoney / coin >= 1) {
            int needCoins = afterDealMoney / coin;
            int changes = calculateChanges(needCoins, coinUnit);
            afterDealMoney = afterDealMoney - coin * changes;
        }
        return afterDealMoney;
    }

    private int calculateChanges(int needNumber, String coinUnit) {
        int leftCoin = Coin.valueOf(coinUnit).getNumber();
        int exchangedCoinNumber = changes.get(coinUnit);
        if (leftCoin <= needNumber) {
            changes.put(coinUnit, exchangedCoinNumber + leftCoin);
            Coin.valueOf(coinUnit).decreaseNum(leftCoin);
            return leftCoin;
        }
        changes.put(coinUnit, exchangedCoinNumber + needNumber);
        Coin.valueOf(coinUnit).decreaseNum(needNumber);
        return needNumber;
    }
}