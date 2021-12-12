package vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class CoinCollection {
    private static final String MACHINE_MONEY_STRING = "자판기가 보유한 동전";
    private static final String COIN500_STRING = "500원 - ";
    private static final String COIN100_STRING = "100원 - ";
    private static final String COIN50_STRING = "50원 - ";
    private static final String COIN10_STRING = "10원 - ";
    private static final String UNIT = "개";
    private static final String NEW_LINE = "\n";


    List<Coin> coins500 = new ArrayList<>();
    List<Coin> coins100 = new ArrayList<>();
    List<Coin> coins50 = new ArrayList<>();
    List<Coin> coins10 = new ArrayList<>();

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

    public boolean isEmpty() {
        return coins500.isEmpty() && coins100.isEmpty() && coins50.isEmpty() && coins10.isEmpty();
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
}
