package vendingmachine.domain;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class VendingMachine {

    private final int DEFAULT_AMOUNT = 0;
    private int amount;
    private Map<Coin, Integer> coinMap;
    private ProductList productList;

    public VendingMachine(int amount) {
        productList = new ProductList();
        this.amount = amount;
        //TODO: amount validate 검증
        generateNumberOfCoinsRandomly(amount);
    }

    private void generateNumberOfCoinsRandomly(int amount) {
        coinMap = new LinkedHashMap<>();

        for (Coin coin : Coin.values()) {
            int randomValue = Randoms.pickNumberInRange(0, amount/coin.getValue());
            amount -= randomValue;
            coinMap.put(coin, randomValue);
        }

        if (amount > DEFAULT_AMOUNT) {
            for (Coin coin : Coin.values()) {
                int quotient = amount/coin.getValue();
                amount -= quotient * coin.getValue();
                coinMap.put(coin, coinMap.get(coin) + quotient);
            }
        }
    }

}
