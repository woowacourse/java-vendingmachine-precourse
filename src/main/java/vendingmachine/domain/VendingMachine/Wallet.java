package vendingmachine.domain.VendingMachine;

import vendingmachine.constants.Coin;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Wallet {
    private final List<CoinCount> coins;

    public Wallet(int money) {
        coins = CoinCount.build(money);
    }

    public String getMessage() {
        return coins.stream()
                .map(CoinCount::getMessage)
                .collect(Collectors.joining("\n"));
    }

    private static class CoinCount {
        private final Coin coin;
        private int count;

        CoinCount(Coin coin, int count) {
            this.coin = coin;
            this.count = count;
        }

        public static List<CoinCount> build(int money) {
            List<CoinCount> ret = new ArrayList<>();
            for (Coin c : Coin.getSortedCoins()) {
                ret.add(new CoinCount(c, money / c.getPrice()));
                money %= c.getPrice();
            }
            return ret;
        }

        public String getMessage() {
            return String.format("%d원 - %d개", coin.getPrice(), count);
        }
    }

}
