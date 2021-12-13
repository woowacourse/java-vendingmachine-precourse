package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
            Coin randomCoin = pickRandomlyLessThan(money);
            if (randomCoin != null) {
                result.add(randomCoin);
                money -= randomCoin.amount;
            }
        }
        return result;
    }

    private static Coin pickRandomlyLessThan(int money) {
        int randomAmount = Randoms.pickNumberInList(Coin.getListOfAmountLessThan(money));
        return Coin.byAmount(randomAmount);
    }

    private static Coin byAmount(int amount) {
        return Arrays.stream(Coin.values())
                .filter(c -> c.amount == amount)
                .findFirst()
                .orElse(null);
    }

    private static List<Integer> getListOfAmountLessThan(int money) {
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

    public static List<Coin> getCoinsInOrder() {
        return Arrays.stream(Coin.values())
                .sorted()
                .collect(Collectors.toList());
    }

    public boolean isLessOrEqualWith(int money) {
        return amount <= money;
    }

    public int subtractFrom(int money) {
        return money - amount;
    }
}
