package vendingmachine.domain;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    /**
     * 이 함수가 요구하는 것은 coin이라는 숫자를 받았을때 Coin Enum을 가져오는 것
     * @param coin
     * @return
     */
    public static Coin valueOf(int coin) {
        return Arrays.stream(Coin.values())
                .filter(Coin -> Coin.amount == coin)
                .findFirst()
                .orElseThrow(null);
    }

    @Override
    public String toString() {
        return this.amount + "원";
    }
}
