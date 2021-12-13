package vendingmachine.domain.possessioncoin;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;

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
        return possessionCoins.stream()
            .filter(PossessionCoin::isExistQuantity)
            .filter(investmentMoney::isPossibleChange)
            .map(possessionCoin -> getChange(investmentMoney, possessionCoin))
            .collect(toList());
    }

    private Change getChange(InvestmentMoney investmentMoney, PossessionCoin possessionCoin) {
        int coinQuantity = possessionCoin.calculatePossibleQuantity(investmentMoney);
        return new Change(possessionCoin.getCoin(), coinQuantity);
    }
}