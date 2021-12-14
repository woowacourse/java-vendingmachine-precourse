package vendingmachine.util;

import java.util.LinkedHashMap;
import java.util.Map;

import vendingmachine.domain.Coin;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtility {
    public Map<Coin, Integer> generateRandomCoins(int inputMoney) {
        Map<Coin, Integer> newCoinHashMap = new LinkedHashMap<>();
        for (Coin coin : Coin.values()) {
            int randomQuotient = Randoms.pickNumberInRange(0, inputMoney / coin.getAmount());
            inputMoney -= (randomQuotient * coin.getAmount());
            newCoinHashMap.put(coin, newCoinHashMap.getOrDefault(coin, 0) + randomQuotient);
        }

        if (inputMoney > 0) {
            for (Coin coin : Coin.values()) {
                int quotient = inputMoney / coin.getAmount();
                inputMoney -= quotient * coin.getAmount();
                newCoinHashMap.put(coin, newCoinHashMap.getOrDefault(coin, 0) + quotient);
            }
        }
        return newCoinHashMap;
    }
}
