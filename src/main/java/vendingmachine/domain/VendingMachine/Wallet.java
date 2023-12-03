package vendingmachine.domain.VendingMachine;

import vendingmachine.constants.Coin;

import java.util.EnumMap;

public class Wallet {
    private final EnumMap<Coin, Integer> coins;

    public Wallet(int money) {
        coins = Coin.getCoins(money);
    }
}
