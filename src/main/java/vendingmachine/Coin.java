package vendingmachine;

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

    public int get() {
        return amount;
    }

    public int pickNumberOfCoins(int balance) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i <= (balance / amount); i++) {
            numbers.add(i);
        }
        return Randoms.pickNumberInList(numbers);
    }
}
