package util;

import domain.Coin;

public interface CoinGenerator {
    int generateRandomCoins(Coin coin, int amount);
}
