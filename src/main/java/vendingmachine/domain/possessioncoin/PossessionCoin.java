package vendingmachine.domain.possessioncoin;

import vendingmachine.domain.Coin;
import vendingmachine.domain.investmentmoney.InvestmentMoney;

public class PossessionCoin {
    private static final int DEFAULT_QUANTITY = 0;

    private final Coin coin;
    private final int quantity;

    public PossessionCoin(Coin coin, int quantity) {
        this.coin = coin;
        this.quantity = quantity;
    }

    public Coin getCoin() {
        return coin;
    }

    public boolean isExistQuantity() {
        if (quantity > DEFAULT_QUANTITY) {
            return true;
        }
        return false;
    }

    public int calculate(InvestmentMoney investmentMoney) {
        return investmentMoney.trade(coin.getAmount(), quantity);
    }

    @Override
    public String toString() {
        return coin.getAmount() + "원 - " + quantity + "개";
    }
}