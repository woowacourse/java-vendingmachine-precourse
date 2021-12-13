package vendingmachine.domain;

import java.util.LinkedHashMap;
import java.util.Map;

import vendingmachine.Coin;

import camp.nextstep.edu.missionutils.Randoms;


public class VendingMachine {

    private Map<Coin, Integer> coinHashMap;

    public VendingMachine(int inputMoney) {
        coinHashMap = generateRandomCoins(inputMoney);
    }

    private Map<Coin, Integer> generateRandomCoins(int inputMoney) {
        Map<Coin, Integer> newCoinHashMap = new LinkedHashMap<>();
        while (inputMoney != 0) {
            inputMoney = extractCoin(inputMoney, newCoinHashMap);
        }
        return newCoinHashMap;
    }

    private int extractCoin(int inputMoney, Map<Coin, Integer> newCoinHashMap) {
        for (Coin coin : Coin.values()) {
            int randomQuotient = Randoms.pickNumberInRange(0, inputMoney / coin.getAmount());
            inputMoney -= (randomQuotient * coin.getAmount());
            newCoinHashMap.put(coin, newCoinHashMap.getOrDefault(coin, 0) + randomQuotient);
        }
        return inputMoney;
    }

    @Override
    public String toString() {
        StringBuilder results = new StringBuilder();
        results.append("자판기가 보유한 동전").append("\n");
        for (Coin holdingCoin : coinHashMap.keySet()) {
            results.append(holdingCoin.toString()).append(" - ").append(coinHashMap.get(holdingCoin)).append("개").append("\n");
        }
        return results.toString();
    }
}
