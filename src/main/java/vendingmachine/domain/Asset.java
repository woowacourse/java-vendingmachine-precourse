package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

import vendingmachine.domain.enums.Coin;

public class Asset {

    private MoneyBill moneyBill;
    private final Coins coins;

    public Asset(int amount) {
        this.moneyBill = new MoneyBill(amount);
        this.coins = new Coins();
    }
}
