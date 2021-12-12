package vendingmachine.model;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.util.constant.Symbol;

import java.util.ArrayList;
import java.util.List;

public class Change {
    private final Coin coin;
    private int number = 0;

    public Change(Coin coin) {
        this.coin = coin;
    }

    public Coin getCoin() {
        return coin;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return coin.getAmount() + Symbol.WON +
                Symbol.HYPHEN_SPACE +
                number + Symbol.COUNT;
    }

    public void addNumber(int number) {
        this.number += number;
    }

    public int pickRandomNumber(int amount) {
        int maxRange = amount / coin.getAmount();
        List<Integer> ranges = getRangeList(maxRange);
        return Randoms.pickNumberInList(ranges);
    }

    private List<Integer> getRangeList(int max) {
        List<Integer> ranges = new ArrayList<>();

        for (int i = 0; i <= max; i++) {
            ranges.add(i);
        }
        return ranges;
    }
}
