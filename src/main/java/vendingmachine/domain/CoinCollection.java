package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

import static vendingmachine.Constant.*;

public class CoinCollection {
    private static final String MACHINE_MONEY_STRING = "자판기가 보유한 동전";
    private static final String CHANGE_STRING = "잔돈";

    private final List<Coin> coins500 = new ArrayList<>();
    private final List<Coin> coins100 = new ArrayList<>();
    private final List<Coin> coins50 = new ArrayList<>();
    private final List<Coin> coins10 = new ArrayList<>();

    public void addCoin(Coin coin) {
        if (coin == null) {
            return;
        }
        if (coin == Coin.COIN_500) {
            coins500.add(coin);
        }
        if (coin == Coin.COIN_100) {
            coins100.add(coin);
        }
        if (coin == Coin.COIN_50) {
            coins50.add(coin);
        }
        if (coin == Coin.COIN_10) {
            coins10.add(coin);
        }
    }

    public void pullCoin(Coin coin) {
        if (coin == null) {
            return;
        }
        if (coin == Coin.COIN_500) {
            coins500.remove(coin);
        }
        if (coin == Coin.COIN_100) {
            coins100.remove(coin);
        }
        if (coin == Coin.COIN_50) {
            coins50.remove(coin);
        }
        if (coin == Coin.COIN_10) {
            coins10.remove(coin);
        }
    }

    public boolean isEmpty() {
        return coins500.isEmpty() && coins100.isEmpty() && coins50.isEmpty() && coins10.isEmpty();
    }

    public boolean isRemain(Coin coin) {
        return coins500.contains(coin)
                || coins100.contains(coin)
                || coins50.contains(coin)
                || coins10.contains(coin);
    }

    @Override
    public String toString() {
        String string = "";
        string += MACHINE_MONEY_STRING + NEW_LINE;
        string += COIN500_STRING + coins500.size() + UNIT + NEW_LINE;
        string += COIN100_STRING + coins100.size() + UNIT + NEW_LINE;
        string += COIN50_STRING + coins50.size() + UNIT + NEW_LINE;
        string += COIN10_STRING + coins10.size() + UNIT + NEW_LINE;
        return string;
    }

    public String toStringWithoutEmptyCoin() {
        String string = "";
        string += CHANGE_STRING + NEW_LINE;
        if (coins500.size() > 0) {
            string += COIN500_STRING + coins500.size() + UNIT + NEW_LINE;
        }
        if (coins100.size() > 0) {
            string += COIN100_STRING + coins100.size() + UNIT + NEW_LINE;
        }
        if (coins50.size() > 0) {
            string += COIN50_STRING + coins50.size() + UNIT + NEW_LINE;
        }
        if (coins10.size() > 0) {
            string += COIN10_STRING + coins10.size() + UNIT + NEW_LINE;
        }
        return string;
    }
}
