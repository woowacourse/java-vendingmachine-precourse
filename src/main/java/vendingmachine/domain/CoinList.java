package vendingmachine.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import camp.nextstep.edu.missionutils.Randoms;

public class CoinList {
    private LinkedHashMap<Coin, Integer> coinList = new LinkedHashMap<Coin, Integer>();
    private int money;

    public ArrayList<Integer> getCoinCount() {
        ArrayList<Integer> countList = new ArrayList<Integer>();
        for (Coin coin : Coin.values()) {
            countList.add(coinList.get(coin));
        }
        return countList;
    }

    public void makeRandomCoinList(int money) {
        this.money = money;
        for (Coin coin : Coin.values()) {
            makeRandomCoin(coin);
        }
    }

    private void makeRandomCoin(Coin coin) {
        if (coin == Coin.COIN_10) {
            coinList.put(coin, this.money / coin.getAmount());
            return;
        }
        int number = Randoms.pickNumberInRange(0, this.money / coin.getAmount());
        this.money -= (coin.getAmount() * number);
        coinList.put(coin, number);
    }
}
