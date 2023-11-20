package vendingmachine.coin;

import java.util.Arrays;
import vendingmachine.exception.VendingMachineException;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    // 추가 기능 구현
    public static Coin getCoins(int amount){
        return Arrays.stream(values())
                .filter(coin -> coin.amount == amount)
                .findFirst()
                .orElseThrow(VendingMachineException.INVALID_COIN_AMOUNT::makeException);
    }


    public int getAmount() {
        return amount;
    }
}
