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

    public int getCoinAmount() {
        return this.amount;
    }

    public void setCoinNumber() {
        this.number++;
    }

    public void minusCoinNumber() {
        this.number--;
    }

    public int getCoinHowMuch() {
        return this.amount * this.number;
    }


}
