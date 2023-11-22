package vendingmachine.domain;

import vendingmachine.utils.VendingMachineAmountValidator;

import java.util.EnumMap;

public class VendingMachineCoins {
    private final EnumMap<Coin, Long> coins;

    private VendingMachineCoins(EnumMap<Coin, Long> coins) {
        this.coins = coins;
    }

    public static VendingMachineCoins from(long amount) {
        VendingMachineAmountValidator.validateDividedByMinimumAmount(amount);
        //TODO enumMap 생성
        EnumMap<Coin, Long> coins = Coin.generateMinimumCoins(amount);
        return new VendingMachineCoins(coins);
    }
}
