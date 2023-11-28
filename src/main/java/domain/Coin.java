package domain;

import camp.nextstep.edu.missionutils.Randoms;
import util.exception.NoMatchingCoinException;
import util.message.ExceptionMessage;

import java.util.Arrays;
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

    public static Coin from(int amount) {
        try {
            return Arrays.stream(Coin.values())
                    .filter(coin -> coin.getAmount() == amount)
                    .findFirst()
                    .orElseThrow(() -> new NoMatchingCoinException(ExceptionMessage.NOT_COIN_MESSAGE.getValue()));
        } catch (NoMatchingCoinException ex) {
            throw new NoMatchingCoinException(String.format(ExceptionMessage.NOT_COIN_MESSAGE.getValue(), amount));
        }
    }


    public static Coin pickRandomWithLimit(int balanceLimit) {
        Coin randomCoin = Coin.pickRandom();
        if (randomCoin.getAmount() > balanceLimit) {
            return pickRandomWithLimit(balanceLimit);
        }

        return randomCoin;
    }

    private static Coin pickRandom() {
        int pickedAmount = Randoms.pickNumberInList(
                Arrays.stream(values())
                        .map(Coin::getAmount)
                        .collect(Collectors.toList())
        );

        return Coin.from(pickedAmount);
    }

    public int getAmount() {
        return amount;
    }

}
