package vendingmachine.strategy;

import vendingmachine.domain.Coin;

@FunctionalInterface
public interface CoinCreateStrategy {

    Coin createCoin();
}
