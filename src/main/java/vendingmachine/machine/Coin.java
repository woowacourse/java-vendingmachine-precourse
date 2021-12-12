package vendingmachine.machine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Coin {
    COIN_500(500,0),
    COIN_100(100,0),
    COIN_50(50,0),
    COIN_10(10,0);

    private final int amount;
    public int number;

    Coin(final int amount, int number) {
        this.amount = amount;
        this.number = number;
    }

    public void setCoinNumber() {
        this.number++;
    }

    public int getCoin500AllAmount() {
        return COIN_500.amount * COIN_500.number;
    }

    public int getCoin100AllAmount() {
        return COIN_100.amount * COIN_100.number;
    }

    public int getCoin50AllAmount() {
        return COIN_50.amount * COIN_50.number;
    }

    public int getCoin10AllAmount() {
        return COIN_10.amount * COIN_10.number;
    }

    public List<Integer> getAllCoinsAmount() {
        List<Integer> coin = new ArrayList<>();
        coin.add(COIN_500.amount);
        coin.add(COIN_100.amount);
        coin.add(COIN_50.amount);
        coin.add(COIN_10.amount);

        return coin;
    }

    public int getRandomCoinAmount() {
        List<Integer> coin = getAllCoinsAmount();

        int pickAmount = Randoms.pickNumberInList(coin);

        return pickAmount;
    }

   public int getAllCurrentAmount() {
        int sum = 0;
        sum = getCoin500AllAmount() + getCoin100AllAmount() + getCoin50AllAmount() + getCoin10AllAmount();

        return sum;
   }

}
