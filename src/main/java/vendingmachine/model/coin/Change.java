package vendingmachine.model.coin;

import java.util.LinkedList;
import java.util.List;

import vendingmachine.model.user.UserMoney;
import vendingmachine.util.Constant;

public class Change {
    private final List<CoinType> coins;

    public Change(MachineMoney money) {
        coins = money.createCoins();
    }

    public List<CoinType> createChange(UserMoney money) {
        List<CoinType> change = new LinkedList<>();
        int total = money.getAmount();

        for (CoinType type : coins) {
            int amount = type.maxAmount(total);
            Coin coinType = type.getType();
            if (amount > Constant.EMPTY) {
                change.add(new CoinType(coinType, amount));
                decCoins(type, amount);
                total -= amount * coinType.getAmount();
            }
        }
        return change;
    }

    private void decCoins(CoinType type, int useCoin) {
        type.decAmount(useCoin);
    }

    public List<CoinType> getCoins() {
        return coins;
    }
}
