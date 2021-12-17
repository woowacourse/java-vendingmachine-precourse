package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.utils.CommonConstant;

import java.util.LinkedHashMap;
import java.util.Map;

public class CoinMap {
    private Map<Coin, Integer> coinMap;

    public CoinMap() {
        coinMap = new LinkedHashMap<>();
    }

    public void updateValue(Coin coin, int value) {
        coinMap.put(coin, value);
    }


    public void generateNumberOfCoinsRandomly(int amount) {
        coinMap = new LinkedHashMap<>();

        for (Coin coin : Coin.values()) {
            int randomValue = Randoms.pickNumberInRange(0, amount/coin.getValue());
            amount -= randomValue * coin.getValue();
            updateValue(coin, randomValue);
        }

        if (amount > CommonConstant.DEFAULT_AMOUNT) {
            for (Coin coin : Coin.values()) {
                int quotient = amount/coin.getValue();
                amount -= quotient * coin.getValue();
                updateValue(coin, coinMap.get(coin) + quotient);
            }
        }
    }

    public int calculateValueUsingQuotient(Coin coin, int quotient) {
        if (quotient > coinMap.get(coin)) return coinMap.get(coin);
        return quotient;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Coin coin : coinMap.keySet()) {
            stringBuilder.append(coin).append(CommonConstant.CONNECTION_MARK).append(coinMap.get(coin)).append(CommonConstant.COINS_POSTFIX);
        }
        return stringBuilder.toString();
    }
}
