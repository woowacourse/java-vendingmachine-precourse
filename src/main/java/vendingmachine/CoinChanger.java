package vendingmachine;

import java.util.EnumMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
            if (coin == Coin.COIN_10) {
                coins.put(coin, holdingSum / coin.getAmount());
            }
            if (holdingSum >= coin.getAmount()) {
                int portion = Randoms.pickNumberInList(
                    IntStream.range(0, holdingSum / coin.getAmount() + 1).boxed().collect(
                        Collectors.toList()));
                coins.put(coin, portion);
                holdingSum -= coin.getAmount() * portion;
            }
        }
        return coins;
    }
}
