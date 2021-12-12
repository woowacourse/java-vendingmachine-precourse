package vendingmachine.domain.possessioncoin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import vendingmachine.domain.Coin;
import vendingmachine.domain.investmentmoney.InvestmentMoney;
import vendingmachine.domain.change.Change;

public class PossessionCoins {
    List<PossessionCoin> possessionCoins;

    public PossessionCoins(List<PossessionCoin> possessionCoins) {
        this.possessionCoins = possessionCoins;
    }

    public List<PossessionCoin> getPossessionCoins() {
        return Collections.unmodifiableList(possessionCoins);
    }

    public List<Change> takeChange(InvestmentMoney investmentMoney) {
        List<Change> changes = new ArrayList<>();

        for (PossessionCoin possessionCoin : possessionCoins) {
            Coin coin = possessionCoin.getCoin();
            if (possessionCoin.isExistQuantity() && investmentMoney.isPossibleChange(coin)) {
                int coinQuantity = possessionCoin.calculate(investmentMoney);
                changes.add(new Change(coin, coinQuantity));
            }
        }

        return changes;
    }
}