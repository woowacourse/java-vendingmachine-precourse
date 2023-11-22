package vendingmachine.domain;

import vendingmachine.utils.VendingMachineAmountValidator;

import java.util.EnumMap;

public class VendingMachineCoins {
    private final long totalAmount;
    private final EnumMap<Coin, Long> coins;

    private VendingMachineCoins(long totalAmount, EnumMap<Coin, Long> coins) {
        this.totalAmount = totalAmount;
        this.coins = coins;
    }

    public static VendingMachineCoins from(long amount) {
        VendingMachineAmountValidator.validateDividedByMinimumAmount(amount);
        EnumMap<Coin, Long> coins = Coin.generateMinimumCoins(amount);
        return new VendingMachineCoins(amount, coins);
    }

    public EnumMap<Coin, Long> generateExchangeCoins(long amount) {
        if (amount > totalAmount) {
            return new EnumMap<>(coins);
        }

        EnumMap<Coin, Long> exchangeCoins = new EnumMap<>(Coin.class);

        for (Coin coin : Coin.values()) {
            long coinCount = Math.min(coins.get(coin), amount / coin.getAmount());
            amount -= coinCount * coin.getAmount();
            coins.put(coin, coins.get(coin) - coinCount);
            exchangeCoins.put(coin, coinCount);
        }
        return exchangeCoins;
    }
}
