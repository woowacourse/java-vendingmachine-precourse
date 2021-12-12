package vendingmachine.domain.possessioncoin;

import vendingmachine.domain.possessionmoney.PossessionMoney;

@FunctionalInterface
public interface PossessionCoinsGenerator {
    PossessionCoins generate(PossessionMoney possessionMoney);
}