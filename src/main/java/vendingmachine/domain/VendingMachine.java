package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;
import vendingmachine.Coin;

public class VendingMachine {

    private static final String ERR_PREFIX = "[ERROR]";
    private static final String ERR_INVALID_TOTAL_AMOUNT = ERR_PREFIX + "금액음 10 단위로 나누어 떨어져야합니다.";
    private static final int MIN_VALUE = 10;
    private final List<Coin> coins;

    public VendingMachine(int totalAmount) {
        validateTotalAmount(totalAmount);
        this.coins = fillChanges(totalAmount, new ArrayList<>());
    }

    private List<Coin> fillChanges(int totalAmount, List<Coin> coins) {
        Coin coin;
        if (totalAmount == 0) {
            return coins;
        }
        coin = Coin.getRandomCoinBelowAmount(totalAmount);
        coins.add(coin);
        return fillChanges(totalAmount - coin.getAmount(), coins);
    }

    private void validateTotalAmount(int totalAmount) {
        if (totalAmount % MIN_VALUE != 0) {
            throw new IllegalArgumentException(ERR_INVALID_TOTAL_AMOUNT);
        }
    }
}
