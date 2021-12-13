package vendingmachine.domain.coin;

public class CoinGenerator {

    public static void calculatePossibleCoinCombination(CoinCombination coinCombination, int amount) {
        for (Coin coin : Coin.values()) {
            coinCombination.put(coin, coin.countCoin(amount));
            amount = coin.countReducedAmount(amount);
        }
    }

}
