package vendingmachine.domain.coin;

import java.util.EnumMap;
import vendingmachine.domain.coin.generator.CoinGenerator;
import vendingmachine.domain.money.Money;
import vendingmachine.exception.VendingMachineException;

public class Coins {
    public static final int PRINCE_UNIT = 10;
    private final EnumMap<Coin, Integer> coins;

    public Coins(int money, CoinGenerator generator) {
        validateMoney(money);
        this.coins = generator.generate(money);
    }

    private void validateMoney(int money) {
        if (money < 0) {
            throw VendingMachineException.MONEY_MUST_NOT_NEGATIVE.makeException();
        }

        if (money % PRINCE_UNIT != 0) {
            throw VendingMachineException.INVALID_MONEY_UNIT.makeException(PRINCE_UNIT);
        }
    }

    public int getCoinCount(Coin coin) {
        return coins.get(coin);
    }

    public EnumMap<Coin, Integer> returnCoins(Money remainMoney) {
        EnumMap<Coin, Integer> returnCoins = new EnumMap<>(Coin.class);
        int change = remainMoney.getPrice();
        for (Coin coin : Coin.values()) {
            int count = 0;
            while (change > coin.getAmount() && coins.get(coin) > 0) {
                change -= coin.getAmount();
                coins.put(coin, coins.get(coin) - 1);
                count++;
            }
            if (count != 0) {
                returnCoins.put(coin, count);
            }
        }
        return returnCoins;
    }
}
