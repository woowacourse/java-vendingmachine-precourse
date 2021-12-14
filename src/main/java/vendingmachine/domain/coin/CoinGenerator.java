package vendingmachine.domain.coin;

public class CoinGenerator {

    public static CoinCombination calculatePossibleCoinCombination(int amount) {
        CoinCombination coinCombination = new CoinCombination();
        for (Coin coin : Coin.values()) {
            coinCombination.put(coin, coin.countCoin(amount));
            amount = coin.countReducedAmount(amount);
        }
        return coinCombination;
    }

}
