package vendingmachine.domain;

import java.util.HashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Change {
    private static final int DEFAULT_STOCK = 0;
    private static final int ADD_COIN = 1;
    private static final int ZERO = 0;
    private int inputChange;
    private HashMap<Coin, Integer> coinStorage = new HashMap<>();

    public Change(int inputChange) {
        this.inputChange = inputChange;
        initialCoinStorage();
        createRandomCoin();
    }

    private void initialCoinStorage() {
        for (Coin coin : Coin.values()) {
            coinStorage.put(coin, DEFAULT_STOCK);
        }
    }

    public HashMap<Coin, Integer> getCoinStorage() {
        return coinStorage;
    }

    public void returnChange(Customer customer) {
        for (Coin coin : Coin.values()) {
            int coinStock = coinStorage.get(coin);
            int returnStock = coin.returnChange(customer.getCustomerMoney(), coinStock);
            coinStorage.put(coin, coinStock - returnStock);
            customer.addCoin(coin, returnStock);
        }
    }

    private void createRandomCoin() {
        int ownChange = inputChange;
        List<Integer> list = Coin.getCoinAmountList();
        while (ownChange != ZERO) {
            int coinAmount = Randoms.pickNumberInList(list);
            if (coinAmount > ownChange) {
                continue;
            }
            ownChange -= coinAmount;
            Coin coin = Coin.getCoinByAmount(coinAmount);
            coinStorage.put(coin, coinStorage.get(coin) + ADD_COIN);
        }
    }
}
