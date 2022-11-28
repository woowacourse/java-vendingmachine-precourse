package vendingmachine;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import util.Validator;

public class CoinChanger {
    EnumMap<Coin, Integer> coins = new EnumMap<>(Coin.class);
    private int holdingSum;

    public CoinChanger(int holdingSum) {
        Validator.validateDivisibleByMinimumMonetaryUnit(holdingSum);
        this.holdingSum = holdingSum;
    }

    public EnumMap<Coin, Integer> changeToCoin() {
        init();
        do {
            change();
        } while (holdingSum != 0);
        return coins;
    }

    private void init() {
        for (Coin coin : Coin.values()) {
            coins.put(coin, 0);
        }
    }

    private void change() {
        int amount = Randoms.pickNumberInList(
            Arrays.stream(Coin.values()).mapToInt(Coin::getAmount).boxed().collect(Collectors.toList()));
        if (holdingSum >= amount) {
            holdingSum -= amount;
            coins.forEach(((coin, integer) -> {if (coin.getAmount() == amount) coins.put(coin, integer + 1);
            }));
        }
    }
}
