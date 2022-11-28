package vendingmachine;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import util.Validator;

public class CoinChanger {
    private int holdingSum;

    public CoinChanger(int holdingSum) {
        Validator.validateDivisibleByMinimumMonetaryUnit(holdingSum);
        this.holdingSum = holdingSum;
    }

    public EnumMap<Coin, Integer> changeToCoin() {
        EnumMap<Coin, Integer> coins = new EnumMap<>(Coin.class);
        for (Coin coin : Coin.values()) {
            coins.put(coin, 0);
        }
        do {
            int amount = Randoms.pickNumberInList(
                Arrays.stream(Coin.values()).mapToInt(Coin::getAmount).boxed().collect(Collectors.toList()));
            if (holdingSum >= amount) {
                holdingSum -= amount;
                coins.forEach(((coin, integer) -> {if (coin.getAmount() == amount) coins.put(coin, integer + 1);}));
            }
        } while (holdingSum != 0);

        return coins;
    }
}
