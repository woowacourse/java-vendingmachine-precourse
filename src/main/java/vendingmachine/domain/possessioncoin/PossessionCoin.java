package vendingmachine.domain.possessioncoin;

import vendingmachine.domain.Coin;
import vendingmachine.domain.investmentmoney.InvestmentMoney;

public class PossessionCoin {
    private static final int DEFAULT_QUANTITY = 0;
    private static final String TO_STRING_FORMAT = "%d원 - %d개";

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
        return quantity > DEFAULT_QUANTITY;
    }

    public int calculatePossibleQuantity(InvestmentMoney investmentMoney) {
        return investmentMoney.trade(coin.getAmount(), quantity);
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_FORMAT, coin.getAmount(), quantity);
    }
}