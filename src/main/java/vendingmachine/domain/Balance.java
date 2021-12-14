package vendingmachine.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class Balance {
    private final int DEFAULT_VALUE = 0;
    private final int CHANGE_VALUE = 1;
    private final Map<Coin, Integer> balanceCoin;
    private Map<Coin, Integer> changeCoin;

    public Balance() {
        balanceCoin = new LinkedHashMap<>();
        resetCoin();
    }

    public Map<Coin, Integer> getBalanceCoin() {
        return balanceCoin;
    }

    public Map<Coin, Integer> getChangeCoin() {
        return changeCoin;
    }

    private void resetCoin() {

        for (Coin coin : Coin.values()) {
            balanceCoin.put(coin, DEFAULT_VALUE);
        }

    }

    private List<Integer> provideCoinList() {
        List<Integer> coinList = new ArrayList<>();

        for (Coin coin : Coin.values()) {
            coinList.add(coin.getAmount());
        }

        return coinList;
    }

    private void addBalanceCoin(int randomCoin) {
        Coin coin = Coin.getCoinByAmount(randomCoin);
        balanceCoin.put(coin, balanceCoin.get(coin) + CHANGE_VALUE);
    }

    public void calculateBalanceCoin(String balanceInput) {
        List<Integer> coinList = provideCoinList();
        int balance = Integer.parseInt(balanceInput);

        while (balance > DEFAULT_VALUE) {
            int randomCoin = Randoms.pickNumberInList(coinList);

            if (balance - randomCoin >= DEFAULT_VALUE) {
                balance -= randomCoin;
                addBalanceCoin(randomCoin);
            }

        }

    }

    private void balanceToChange(Coin coin, int count) {

        if (count != DEFAULT_VALUE) {
            balanceCoin.put(coin, balanceCoin.get(coin) - count);
            changeCoin.put(coin, count);
        }

    }

    public void calculateChangeCoin(int remainMoney) {
        changeCoin = new LinkedHashMap<>();

        for (Coin coin : Coin.values()) {

            if (balanceCoin.get(coin) != DEFAULT_VALUE) {
                int count = Math.min(remainMoney / coin.getAmount(), balanceCoin.get(coin));
                balanceToChange(coin, count);
                remainMoney -= coin.getAmount() * count;
            }

        }

    }
}
