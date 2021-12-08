package vendingmachine.domain.enums;

import vendingmachine.utils.ExceptionMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    public int getAmount() {
        return amount;
    }

    Coin(final int amount) {
        this.amount = amount;
    }

    public static List<Integer> getCoinAmountList(){
        return Arrays.asList(Coin.values())
                .stream()
                .map(coin -> coin.getAmount())
                .collect(Collectors.toList());
    }

    public static Coin getCoinByNumber(int number){
        return Arrays.stream(Coin.values())
                .filter(coin -> coin.getAmount() == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.ERROR_PREFIX + ExceptionMessage.ERROR_COIN_NOT_FOUND));
    }

}
