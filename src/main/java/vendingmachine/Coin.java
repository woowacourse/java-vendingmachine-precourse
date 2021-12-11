package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
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

    public static List<Coin> generateCoinsBy(int money) {
        List<Coin> result = new ArrayList<>();
        while (money >= getMinAmount()) {
            int randomAmount = Randoms.pickNumberInList(Coin.getListOfAmountLessThen(money));
            Coin randomCoin = Coin.byAmount(randomAmount);
            if (randomCoin != null) {
                result.add(randomCoin);
                money -= randomCoin.amount;
            }
        }
        return result;
    }

    private static Coin byAmount(int amount) {
        return Arrays.stream(Coin.values())
                .filter(c -> c.amount == amount)
                .findFirst()
                .orElse(null);
    }

    private static List<Integer> getListOfAmountLessThen(int money) {
        Integer[] amounts = Arrays.stream(Coin.values())
                .map(c -> c.amount)
                .filter(i -> i <= money)
                .toArray(Integer[]::new);

        return new ArrayList<>(Arrays.asList(amounts));
    }

    private static Integer getMinAmount() {
        return Arrays.stream(Coin.values())
                .mapToInt(c -> c.amount)
                .min()
                .orElse(COIN_10.amount);
    }
}
