package vendingmachine.domain;

import vendingmachine.domain.Coin;

import static vendingmachine.Constant.*;

public class Change {
    private static final String CHANGE_STRING = "잔돈";

    private int numberOf500 = 0;
    private int numberOf100 = 0;
    private int numberOf50 = 0;
    private int numberOf10 = 0;

    public void addCoin(Coin coin) {
        if (coin == null) {
            return;
        }
        if (coin == Coin.COIN_500) {
            numberOf500++;
        }
        if (coin == Coin.COIN_100) {
            numberOf100++;
        }
        if (coin == Coin.COIN_50) {
            numberOf50++;
        }
        if (coin == Coin.COIN_10) {
            numberOf10++;
        }
    }

    @Override
    public String toString() {
        String string = "";
        string += CHANGE_STRING + NEW_LINE;
        if (numberOf500 > 0) {
            string += COIN500_STRING + numberOf500 + UNIT + NEW_LINE;
        }
        if (numberOf100 > 0) {
            string += COIN100_STRING + numberOf100 + UNIT + NEW_LINE;
        }
        if (numberOf50 > 0) {
            string += COIN50_STRING + numberOf50 + UNIT + NEW_LINE;
        }
        if (numberOf10 > 0) {
            string += COIN10_STRING + numberOf10 + UNIT + NEW_LINE;
        }
        return string;
    }
}
