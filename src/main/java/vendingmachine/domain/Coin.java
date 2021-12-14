package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public static int getRandomAmount() {
        return Randoms.pickNumberInList(coinValueList());
    }

    private static List<Integer> coinValueList() {
        List<Integer> coinList = new ArrayList<>();
        for (Coin coin : Coin.values()) {
            coinList.add(coin.amount);
        }
        return coinList;
    }
}
